package es.raulgf92.monitoringlog.model;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class FunctionErrorInfo extends FunctionInfo {

	public FunctionErrorInfo(String identificator, Date date, ProceedingJoinPoint joinPoint, Exception e) {
		super(FunctionInfo.FunctionInfoState.ERROR, identificator, date, joinPoint, e);
	}

}
