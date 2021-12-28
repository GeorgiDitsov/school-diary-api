package com.ditsov.school_diary.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiKeyAuthDefinition.ApiKeyLocation;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SwaggerDefinition(
    securityDefinition =
        @SecurityDefinition(
            apiKeyAuthDefinitions = {
              @ApiKeyAuthDefinition(
                  key = HttpHeaders.AUTHORIZATION,
                  name = HttpHeaders.AUTHORIZATION,
                  in = ApiKeyLocation.HEADER)
            }))
public class ApiConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .securityContexts(Arrays.asList(securityContext()))
        .securitySchemes(Arrays.asList(apiKey()))
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("School Diary RESTful APIs")
        .description("This is a brief description of the RESTful APIs.")
        .version("0.1")
        .build();
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder().securityReferences(defaultAuth()).build();
  }

  private List<SecurityReference> defaultAuth() {
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];

    authorizationScopes[0] = new AuthorizationScope("global", "accessEverything");

    return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
  }

  private ApiKey apiKey() {
    return new ApiKey("JWT", HttpHeaders.AUTHORIZATION, "header");
  }
}
