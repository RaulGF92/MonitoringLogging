package io.github.raulgf92.monitoringlog.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;

public class FunctionAnotationMethods {

	private String name;
	private Object value;

	public FunctionAnotationMethods(Annotation annotation, Method method) {
		this.name = method.getName();
		Class<?> clazz = method.getReturnType();
		
			try {
				method.setAccessible(true);
				this.value = method.invoke(annotation, new Object[0]);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				System.out.println("Fallo serializando el metodo " + this.name);
				e.printStackTrace();
				this.value = null;
			}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
