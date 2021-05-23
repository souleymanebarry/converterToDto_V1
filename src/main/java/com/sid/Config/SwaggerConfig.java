package com.sid.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Swagger 2 config using SpringFox
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Configure the Swagger2 api documentation using SpringFox
     *
     * @return the Swagger2 configuration using SpringFox
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.sid.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Dto Synchronization tools").version("1.0.0").build();
    }

    private ApiKey apiKey() {
        return new ApiKey("Authentication", "Authorization", "header");
    }

/*    private SecurityContext securityContext() {
        var securityReferences = List.of(new SecurityReference("Authentication", new AuthorizationScope[0]));
        return SecurityContext.builder().securityReferences(securityReferences).build();
    }*/

}
