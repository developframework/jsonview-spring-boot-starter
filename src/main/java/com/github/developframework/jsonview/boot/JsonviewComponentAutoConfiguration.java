package com.github.developframework.jsonview.boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.developframework.jsonview.boot.annotation.EnableJsonview;
import com.github.developframework.jsonview.core.JsonviewFactory;
import com.github.developframework.jsonview.spring.JsonviewScanLoader;
import com.github.developframework.jsonview.spring.mvc.DataModelReturnValueHandler;
import com.github.developframework.jsonview.spring.mvc.DataNameAnnotationReturnValueHandler;
import com.github.developframework.jsonview.spring.mvc.JsonviewResponseReturnValueHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Auto configuration for Jsonview.
 * {@link EnableJsonview}
 */
@Configuration
@Import(JsonviewWebMvcConfigurer.class)
@AutoConfigureAfter(JacksonAutoConfiguration.class)
@Slf4j
public class JsonviewComponentAutoConfiguration {

    @Bean
    @Autowired
    @ConditionalOnProperty(name = "jsonview.objectmapper.usedefault", havingValue = "true", matchIfMissing = true)
    public JsonviewFactory jsonviewFactoryForDefaultObjectMapper(JsonviewProperties jsonviewProperties, ObjectMapper objectMapper) {
        log.info("Jsonview framework use Jackson default ObjectMapper.");
	    final JsonviewScanLoader loader = new JsonviewScanLoader(jsonviewProperties.getLocations());
        return loader.createJsonviewFactory(objectMapper);
    }

    @Bean
    @ConditionalOnProperty(name = "jsonview.objectmapper.usedefault", havingValue = "false")
    public JsonviewFactory jsonviewFactoryForNewObjectMapper(JsonviewProperties jsonviewProperties) {
        log.info("Jsonview framework use a new ObjectMapper.");
        final JsonviewScanLoader loader = new JsonviewScanLoader(jsonviewProperties.getLocations());
        return loader.createJsonviewFactory();
    }

    @Bean
    public DataModelReturnValueHandler dataModelReturnValueHandler(JsonviewFactory jsonviewFactory) {
        return new DataModelReturnValueHandler(jsonviewFactory);
    }

    @Bean
    public JsonviewResponseReturnValueHandler jsonviewResponseReturnValueHandler(JsonviewFactory jsonviewFactory) {
        return new JsonviewResponseReturnValueHandler(jsonviewFactory);
    }

    @Bean
    public DataNameAnnotationReturnValueHandler dataNameAnnotationReturnValueHandler(JsonviewFactory jsonviewFactory) {
        return new DataNameAnnotationReturnValueHandler(jsonviewFactory);
    }
}
