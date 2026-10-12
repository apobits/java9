package apo.java.practice.cryptography;

import java.util.concurrent.ThreadLocalRandom;

public class OneTimePad {

    private static String key;

    public static String encrypt(String msg){
        key = generateRandomKey(msg.length());

        return null;
    }

    private static String getBinary(String msg){
        var binary = new StringBuilder();
        for(char letter: msg.toCharArray()){
            var binaryString = Integer.toBinaryString(letter);
            binary.append(String.format("%0.6s"));
        }
        return binary.toString();
    }

    private static String generateRandomKey(int size){
        var sb = new StringBuilder();
        while(size-- >0){
            sb.append(ThreadLocalRandom.current().nextInt(0,10));
        }
        return sb.toString();
    }
}
