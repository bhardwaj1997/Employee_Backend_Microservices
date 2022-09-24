package com.employee.config;

import static org.apache.logging.log4j.util.Strings.EMPTY;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

  @Value("${application.author.name}")
  private String authorName;

  @Value("${application.author.email}")
  private String authorEmail;

  @Bean
  public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo(){
    return new ApiInfo("Employee Service","All Employee Api Will be managed here", EMPTY,EMPTY,
        new Contact(authorName,EMPTY,authorEmail),"License of API","API license URL",
        Collections.emptyList());
  }
}
