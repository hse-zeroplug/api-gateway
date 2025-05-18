package com.aaalace.apigateway.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteDefinition {
    private String id;
    private String path;
    private String uri;
    private String circuitBreakerName;
    private String fallbackUri;
    private int retries;
}