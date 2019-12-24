package es.raulgf92.monitoringlog.annotations.monitoringlogui;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(value = {ElementType.CONSTRUCTOR ,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MonitoringLogUI {
	String tag() default "default";
}
