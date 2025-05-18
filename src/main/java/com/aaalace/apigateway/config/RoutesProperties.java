package com.aaalace.apigateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "routes")
public class RoutesProperties {
    private List<RouteDefinition> definitions;
}