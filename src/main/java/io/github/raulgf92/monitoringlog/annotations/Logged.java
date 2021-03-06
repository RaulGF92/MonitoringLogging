package io.github.raulgf92.monitoringlog.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.CONSTRUCTOR ,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Logged {

	Class<?> value() default Logged.class;
	
}
