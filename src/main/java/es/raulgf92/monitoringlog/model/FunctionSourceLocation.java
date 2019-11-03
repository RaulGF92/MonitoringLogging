package es.raulgf92.monitoringlog.model;

import org.aspectj.lang.reflect.SourceLocation;

public class FunctionSourceLocation {

	private Class from;
	private int line;

	public FunctionSourceLocation(SourceLocation sourceLocation) {
		this.line = sourceLocation.getLine();
		this.from = sourceLocation.getWithinType();
	}

	public Class getFrom() {
		return from;
	}

	public void setFrom(Class from) {
		this.from = from;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

}
