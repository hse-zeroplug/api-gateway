package com.aaalace.apigateway;

import com.aaalace.apigateway.config.RouteDefinition;
import com.aaalace.apigateway.config.RoutesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, RoutesProperties routesProps) {
        RouteLocatorBuilder.Builder routeBuilder = builder.routes();

        for (RouteDefinition def : routesProps.getDefinitions()) {
            routeBuilder.route(def.getId(), r -> r
                    .path(def.getPath())
                    .filters(f -> f
                            .stripPrefix(2)
                            .addRequestHeader("X-Gateway", "API-Gateway")
                            .circuitBreaker(c -> c
                                    .setName(def.getCircuitBreakerName())
                                    .setFallbackUri(def.getFallbackUri()))
                            .retry(t -> t
                                    .setRetries(def.getRetries())
                                    .setMethods(HttpMethod.GET, HttpMethod.POST)))
                    .uri(def.getUri()));
        }

        return routeBuilder.build();
    }
}