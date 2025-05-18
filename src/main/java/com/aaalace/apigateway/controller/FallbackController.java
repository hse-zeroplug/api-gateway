package com.aaalace.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
class FallbackController {

    @GetMapping("/fallback/call")
    public Mono<String> serviceFallback() {
        return Mono.just("Service is currently unavailable.");
    }
}