package io.github.raulgf92.monitoringlog.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import io.github.raulgf92.monitoringlog.interceptors.MethodInterceptorLog;

@Import(MethodInterceptorLog.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MonitoringLogging {

}
