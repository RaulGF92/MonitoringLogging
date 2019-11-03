package es.raulgf92.monitoringlog.model;

import java.util.Date;

import org.aspectj.lang.JoinPoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FunctionInfo {

	private String identificator;
	private String executionIdentificator;
	private FunctionSignature signature;
	private Object[] args;
	private FunctionSourceLocation location;
	private Throwable error;
	private Object response;
	private Date executionTime;

	public FunctionInfo() {
	}

	public FunctionInfo(String identificator, Date executionTime, JoinPoint joinPoint) {
		this.identificator = identificator;
		this.executionTime = executionTime;
		this.signature = new FunctionSignature(joinPoint.getSignature());
		this.location = null;
		this.args = joinPoint.getArgs();
	}

	public FunctionInfo(String identificator, Date executionTime, JoinPoint joinPoint, Throwable e) {
		this(identificator, executionTime, joinPoint);
		this.error = e;
	}

	public FunctionInfo(String identificator, Date executionTime, JoinPoint joinPoint, Object response) {
		this(identificator, executionTime, joinPoint);
		this.response = response;
	}

	public String getIdentificator() {
		return identificator;
	}

	public void setIdentificator(String identificator) {
		this.identificator = identificator;
	}

	public String getExecutionIdentificator() {
		return executionIdentificator;
	}

	public void setExecutionIdentificator(String executionIdentificator) {
		this.executionIdentificator = executionIdentificator;
	}

	public FunctionSignature getSignature() {
		return signature;
	}

	public void setSignature(FunctionSignature signature) {
		this.signature = signature;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public FunctionSourceLocation getLocation() {
		return location;
	}

	public void setLocation(FunctionSourceLocation location) {
		this.location = location;
	}

	public Throwable getError() {
		return error;
	}

	public void setError(Throwable error) {
		this.error = error;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

}
