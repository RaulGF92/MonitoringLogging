package es.raulgf92.monitoringlog.model;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class FunctionStartInfo extends FunctionInfo {

	public FunctionStartInfo(String identificator, Date date, ProceedingJoinPoint joinPoint) {
		super(FunctionInfo.FunctionInfoState.START, identificator, date, joinPoint);
	}
	
}
