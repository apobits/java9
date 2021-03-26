package apo.java.practice.varieties;

import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.provider.sftp.IdentityInfo;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SFTPUtil {
    private final FileSystemManager fileSystemManager;
    private final FileSystemOptions fileSystemOptions;
    private final String baseURL;
    private final List<FileObject> fileObjects = new ArrayList<FileObject>();

    public static void main(String[] args) {
	try {
	    SFTPUtil sftpUtil = new SFTPUtil("10.18.150.80", "j_mili",
			    "D:\\stefanini\\project\\resources-manager\\docs\\millicom-rm-files\\change" + "-request-009\\docs\\NonProdSFTP.PPK", 0,
			    false);
	    FileObject[] objects = sftpUtil.getFiles("/interface/j_mili/EBSPPRD/outgoing/GT/GLB-AR-004-DTC-SYNC/", "DTC_.*");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public SFTPUtil(String host, String user, String privatePublicKeyURL, int timeout, boolean isRootDirectory) throws Exception {
	baseURL = "sftp://" + user + "@" + host;
	try {
	    fileSystemManager = VFS.getManager();
	    fileSystemOptions = createFileSystemOptions(timeout, isRootDirectory, new File(privatePublicKeyURL));
	} catch (FileSystemException e) {
	    throw new Exception(e);
	}
    }

    private FileSystemOptions createFileSystemOptions(int timeout, boolean isRootDirectory, File ppkFile) throws FileSystemException {
	FileSystemOptions fileSystemOptions = new FileSystemOptions();
	IdentityInfo identityInfo = new IdentityInfo(ppkFile);
	SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(fileSystemOptions, isRootDirectory);
	SftpFileSystemConfigBuilder.getInstance().setIdentityInfo(fileSystemOptions, identityInfo);
	SftpFileSystemConfigBuilder.getInstance().setTimeout(fileSystemOptions, timeout);

	return fileSystemOptions;
    }

    /**
     * Return the files from the source folder that matches the specified regex
     *
     * @param source source folder where the files are stored
     * @param regex  regular expression to match the files
     * @return array of FileObject instances
     * @throws Exception
     */
    public FileObject[] getFiles(String source, String regex) throws Exception {
	try {
	    String path = baseURL + source;
	    FileObject[] files = fileSystemManager.resolveFile(path, fileSystemOptions).findFiles(new PatternFileSelector(regex));
	    if (files != null) {
		fileObjects.addAll(Arrays.asList(files));
		return files;
	    } else {
	    }
	    return new FileObject[] {};
	} catch (FileSystemException e) {
	    throw new Exception(e);
	}
    }

    /**
     * Ad hoc move file method, it was created as not all SFTP servers support move command
     *
     * @param from FileObject to move
     * @param path Path where to put the new file
     * @throws Exception
     */
    public FileObject moveFile(FileObject from, String path) throws Exception {
	return moveFileHelper(from, path, from.getName().getBaseName());
    }

    /**
     * Ad hoc rename file method, it was created as not all SFTP servers support rename command
     *
     * @param from    File object to rename
     * @param path    Path where to put the renamed file
     * @param newName new File object's name
     * @throws Exception
     */
    public FileObject renameFile(FileObject from, String path, String newName) throws Exception {
	return moveFileHelper(from, path, newName);
    }

    private FileObject moveFileHelper(FileObject from, String path, String name) throws Exception {
	FileObject to;
	try {
	    to = fileSystemManager.resolveFile(baseURL + path + name, fileSystemOptions);
	    if (to.exists()) {
		fileObjects.add(to);
		throw new Exception("File already exists");
	    }
	    to.createFile();

	    //inner try to delete the file in case of some error
	    try {
		write(to, mergeLines(readLines(from)));
	    } catch (Exception e) {
		to.delete();
		throw e;
	    }

	    if (!from.delete()) {
		to.delete();
		throw new Exception("File: " + from.getName() + " could not be moved to: " + to.getName());
	    }
	    fileObjects.add(to);
	} catch (FileSystemException e) {
	    throw new Exception(e);
	}
	return to;
    }

    private String mergeLines(List<String> lines) {
	StringBuilder stringBuilder = new StringBuilder();
	for (String line : lines) {
	    stringBuilder.append(line).append("\n");
	}
	return stringBuilder.toString();
    }

    /**
     * Obtain from the specified FileObject a list containing the lines of the file
     *
     * @param fileObject
     * @return the list containing the lines of the file
     * @throws Exception
     */
    public List<String> readLines(FileObject fileObject) throws Exception {
	BufferedReader bufferedReader = null;
	List<String> lines = new ArrayList<String>();
	try {
	    bufferedReader = new BufferedReader(new InputStreamReader(fileObject.getContent().getInputStream(), Charset.forName("UTF-8")));
	    String line;
	    while ((line = bufferedReader.readLine()) != null) {
		lines.add(line);
	    }
	} catch (IOException e) {
	    throw new Exception(e);
	} finally {
	    if (bufferedReader != null) {
		try {
		    bufferedReader.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return lines;
    }

    /**
     * Close all the file objects that this class has produced
     * If FileObjects are created from those obtained from this class, remember to close them manually
     */
    public void close() {
	for (FileObject fileObject : fileObjects) {
	    try {
		fileObject.close();
	    } catch (FileSystemException e) {
	    }
	}
	fileObjects.clear();
    }

    /**
     * Creates the file with the specified data
     *
     * @param data     data to save in the file
     * @param path     path where the file is saved, it must start with and end with /
     * @param fileName name of the file, it must contain the name and its extension
     * @throws Exception
     */
    public void createFile(String data, String path, String fileName) throws Exception {
	FileObject fileObject;
	try {
	    fileObject = fileSystemManager.resolveFile(baseURL + path + fileName, fileSystemOptions);
	    fileObject.createFile();
	    write(fileObject, data);
	} catch (FileSystemException e) {
	    throw new Exception(e);
	}
	fileObjects.add(fileObject);
    }

    private void write(FileObject fileObject, String data) throws Exception {
	OutputStreamWriter outputStreamWriter = null;
	try {
	    outputStreamWriter = new OutputStreamWriter(fileObject.getContent().getOutputStream(), StandardCharsets.UTF_8);
	    outputStreamWriter.write(data);
	    outputStreamWriter.flush();
	} catch (IOException e) {
	    throw new Exception(e);
	} finally {
	    if (outputStreamWriter != null) {
		try {
		    outputStreamWriter.close();
		} catch (IOException e) {
		}
	    }
	}
    }
}
