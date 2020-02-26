package io.github.raulgf92.monitoringlog.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.aspectj.lang.Signature;

public class FunctionClassContainer {

	private ArrayList<FunctionField> fields;
	private ArrayList<FunctionMethod> methods;
	private ArrayList<FunctionAnotation> anotations;
	private String name;

	public FunctionClassContainer(Signature signature) {
		
		this.name = signature.getDeclaringTypeName();
		this.parseAnotations(signature);
		this.parseFields(signature);
		this.parseMethods(signature);
	}

	private void parseFields(Signature signature) {
		this.fields = new ArrayList<FunctionField>();
		Field[] fields = signature.getDeclaringType().getFields();
		for (Field field : fields) {
			this.fields.add(new FunctionField(field));
		}
	}

	private void parseMethods(Signature signature) {
		this.methods = new ArrayList<FunctionMethod>();
		Method[] methods = signature.getDeclaringType().getMethods();
		for (Method method : methods) {
			this.methods.add(new FunctionMethod(method));
		}
		
	}

	private void parseAnotations(Signature signature) {
		this.anotations = new ArrayList<FunctionAnotation>();
		Annotation[] annotations = signature.getDeclaringType().getAnnotations();
		for (Annotation annotation : annotations) {
			this.anotations.add(new FunctionAnotation(annotation));
		}
	}

	public ArrayList<FunctionField> getFields() {
		return fields;
	}

	public void setFields(ArrayList<FunctionField> fields) {
		this.fields = fields;
	}

	public ArrayList<FunctionMethod> getMethods() {
		return methods;
	}

	public void setMethods(ArrayList<FunctionMethod> methods) {
		this.methods = methods;
	}

	public ArrayList<FunctionAnotation> getAnotations() {
		return anotations;
	}

	public void setAnotations(ArrayList<FunctionAnotation> anotations) {
		this.anotations = anotations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
