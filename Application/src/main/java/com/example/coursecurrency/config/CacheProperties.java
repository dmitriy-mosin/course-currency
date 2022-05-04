package com.example.coursecurrency.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConstructorBinding
@ConfigurationProperties(prefix = "cache")
public record CacheProperties(List<CacheSpecification> specifications) {

    public record CacheSpecification(String name, String spec) {
    }
}