package es.raulgf92.monitoringlog.model;


import org.aspectj.lang.Signature;

public class FunctionSignature {

	private String name;
	private FunctionClassContainer classContainer;

	public FunctionSignature(Signature signature) {
		this.name = signature.getName();
		this.classContainer = new FunctionClassContainer(signature);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FunctionClassContainer getClassContainer() {
		return classContainer;
	}

	public void setClassContainer(FunctionClassContainer classContainer) {
		this.classContainer = classContainer;
	}

}
