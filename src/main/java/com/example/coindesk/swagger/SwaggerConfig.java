package com.example.coindesk.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@EnableOpenApi
@Configuration
public class SwaggerConfig {

    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.OAS_30);
        return docket.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.coindesk.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("Writer: BuckJhangjian","","");
        return new ApiInfo(
                "API Document",
                "",
                "1.0.0",
                "",
                contact,
                "",
                "",
                new ArrayList<>());
    }
}
