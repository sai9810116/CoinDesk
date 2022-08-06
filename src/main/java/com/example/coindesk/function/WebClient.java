package com.example.coindesk.function;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WebClient {
    private final RestTemplateBuilder restTemplateBuilder;

    public WebClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public RestTemplate restTemplate() {
        return restTemplateBuilder
                .requestFactory(OkHttp3ClientHttpRequestFactory::new)
                .build();
    }
}
