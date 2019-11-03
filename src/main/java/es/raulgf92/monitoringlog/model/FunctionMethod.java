package es.raulgf92.monitoringlog.model;

import java.lang.reflect.Method;

public class FunctionMethod {

	private String name;

	public FunctionMethod(Method method) {
		this.name = method.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
