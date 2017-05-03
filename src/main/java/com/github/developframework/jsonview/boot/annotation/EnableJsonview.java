package com.github.developframework.jsonview.boot.annotation;

import com.github.developframework.jsonview.boot.JsonviewComponentAutoConfiguration;
import com.github.developframework.jsonview.boot.JsonviewProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableConfigurationProperties(JsonviewProperties.class)
@Import(JsonviewComponentAutoConfiguration.class)
public @interface EnableJsonview {

}
