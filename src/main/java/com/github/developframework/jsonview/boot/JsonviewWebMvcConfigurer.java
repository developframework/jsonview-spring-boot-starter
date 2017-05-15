package com.github.developframework.jsonview.boot;

import com.github.developframework.jsonview.spring.mvc.DataModelReturnValueHandler;
import com.github.developframework.jsonview.spring.mvc.DataNameAnnotationReturnValueHandler;
import com.github.developframework.jsonview.spring.mvc.JsonviewResponseReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class JsonviewWebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	private DataModelReturnValueHandler dataModelReturnValueHandler;

	@Autowired
	private JsonviewResponseReturnValueHandler jsonviewResponseReturnValueHandler;

	@Autowired
	private DataNameAnnotationReturnValueHandler dataNameAnnotationReturnValueHandler;

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		returnValueHandlers.add(jsonviewResponseReturnValueHandler);
		returnValueHandlers.add(dataModelReturnValueHandler);
		returnValueHandlers.add(dataNameAnnotationReturnValueHandler);
	}
}
