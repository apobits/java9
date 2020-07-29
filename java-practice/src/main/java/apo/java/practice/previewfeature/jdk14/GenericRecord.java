package apo.java.practice.previewfeature.jdk14;

public record GenericRecord<T>(T t) {
    public GenericRecord(T t) {
	this.t = t;
    }
}
