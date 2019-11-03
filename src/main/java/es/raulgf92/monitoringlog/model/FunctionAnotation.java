package es.raulgf92.monitoringlog.model;

import java.lang.annotation.Annotation;

public class FunctionAnotation {

	private String name;

	public FunctionAnotation(Annotation annotation) {
		this.name = annotation.annotationType().getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
