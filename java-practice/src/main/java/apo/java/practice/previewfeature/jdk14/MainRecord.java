package apo.java.practice.previewfeature.jdk14;

public class MainRecord {
    public static void main(String[] args) {
	GenericRecord<PersonRecord> personGenericRecord = new GenericRecord<>(new PersonRecord("Perez"));
	System.out.println(personGenericRecord.t().lastName());
    }
}
