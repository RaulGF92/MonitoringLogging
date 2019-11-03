package es.raulgf92.monitoringlog.model;

import java.lang.reflect.Field;

public class FunctionField {

	private String name;
	private String type;

	public FunctionField(Field field) {
		this.name = field.getName();
		this.type = field.getType().getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
