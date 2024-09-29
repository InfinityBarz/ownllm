package com.ownllm.back.promptmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class HttpClientConfiguration {

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)  // Use HTTP/2 as default
                .connectTimeout(Duration.ofSeconds(10))  // Set the connection timeout
                .followRedirects(HttpClient.Redirect.NORMAL)  // Configure redirection policy
                .build();
    }
}