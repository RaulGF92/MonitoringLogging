package io.github.raulgf92.monitoringlog.loggers.lucalog;

import io.github.raulgf92.monitoringlog.model.FunctionInfo;

public class FunctionInfoUI extends FunctionInfo {

	private String applicationName;
	
	public FunctionInfoUI(FunctionInfo info) {
		super();
		this.setArgs(info.getArgs());
		this.setError(info.getError());
		this.setExecutionIdentificator(info.getExecutionIdentificator());
		this.setExecutionTime(info.getExecutionTime());
		this.setIdentificator(info.getIdentificator());
		this.setLocation(info.getLocation());
		this.setResponse(info.getResponse());
		this.setSignature(info.getSignature());
		this.setState(info.getState());
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

}
