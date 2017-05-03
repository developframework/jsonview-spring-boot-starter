package com.github.developframework.jsonview.boot;

import com.github.developframework.jsonview.springmvc.DataModelReturnValueHandler;
import com.github.developframework.jsonview.springmvc.JsonviewResponseReturnValueHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@Slf4j
public class JsonviewWebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	private DataModelReturnValueHandler dataModelReturnValueHandler;

	@Autowired
	private JsonviewResponseReturnValueHandler jsonviewResponseReturnValueHandler;

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		returnValueHandlers.add(jsonviewResponseReturnValueHandler);
		returnValueHandlers.add(dataModelReturnValueHandler);
	}
}
