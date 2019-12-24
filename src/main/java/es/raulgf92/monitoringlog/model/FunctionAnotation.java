package es.raulgf92.monitoringlog.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FunctionAnotation {

	private String name;
	private List<FunctionAnotationMethods> methods;
	
	public FunctionAnotation(Annotation annotation) {
		this.name = annotation.annotationType().getName();
		this.methods = new ArrayList<FunctionAnotationMethods>();
		for (Method method : annotation.annotationType().getDeclaredMethods()) {
			this.methods.add(new FunctionAnotationMethods(annotation,method));
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FunctionAnotationMethods> getMethods() {
		return methods;
	}

	public void setMethods(List<FunctionAnotationMethods> methods) {
		this.methods = methods;
	}

}
