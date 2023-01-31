package com.demo.romannumerals;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RomanNumeralsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RomanNumeralsApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/*/*"))
				.apis(RequestHandlerSelectors.basePackage("com.demo")).build().apiInfo(
						new ApiInfo("Numerals to Digits Converter API",
								"Simple API to convert numerals to digits and digits to numerals ", "1.0",
								"Free to Use",
								new springfox.documentation.service.Contact("Kailasam Mohan Reddy", "<LinkedIn URL>",
										"kailasam.mohanreddy@gmail.com"),
								"API License", "<URL>", Collections.emptyList()));
	}

}
