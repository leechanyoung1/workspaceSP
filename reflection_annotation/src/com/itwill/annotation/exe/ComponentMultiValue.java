package com.itwill.annotation.exe;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

@Retention(RUNTIME)
@Target(TYPE)
public @interface ComponentMultiValue {
	String value() default "";
	String[] names() default{};
	int count();
	boolean print() default false;
	
}
