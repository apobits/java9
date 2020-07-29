package apo.java.practice.previewfeature.jdk14;

import apo.java.practice.general.annotation.NotNull;

public record AnnotationOnRecord(@NotNull String property) {
    public AnnotationOnRecord(
		    @NotNull
				    String property) {
	this.property = property;
    }
}
