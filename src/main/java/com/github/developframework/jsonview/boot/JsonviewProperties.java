package com.github.developframework.jsonview.boot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jsonview")
@Getter
@Setter
public class JsonviewProperties {

    private String locations = "classpath*:jsonview/*.xml";

    private ObjectMapperProperties objectmapper;

    @Getter
    @Setter
    public static class ObjectMapperProperties {
        private boolean usedefault;
    }
}
