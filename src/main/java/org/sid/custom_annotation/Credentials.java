package org.sid.custom_annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

@Retention(RUNTIME)
@Target(TYPE)
@Conditional(CredentialsImpl.class)
public @interface Credentials {

}
