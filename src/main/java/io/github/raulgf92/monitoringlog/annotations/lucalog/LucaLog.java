package io.github.raulgf92.monitoringlog.annotations.lucalog;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(value = {ElementType.CONSTRUCTOR ,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LucaLog {
	String tag() default "default";
}
