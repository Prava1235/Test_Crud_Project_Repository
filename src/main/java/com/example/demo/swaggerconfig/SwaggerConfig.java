package com.example.demo.swaggerconfig;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Address Book API", "Sample API for Test", "1.0", "Free to Use",
				new springfox.documentation.service.Contact("Pravabini Mohanty", "http://java.io", "abc.com"),
				"API License", "http://java.io", Collections.emptyList());

	}

}

