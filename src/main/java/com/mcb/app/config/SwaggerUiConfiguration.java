package com.mcb.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Slf4j
@EnableWebMvc
@EnableSwagger2
public class SwaggerUiConfiguration {

	// 1. give your app info
	private ApiInfo getApiInfo() {
		log.info("ApiInfo built successful!");
		return new ApiInfoBuilder().title("Rest api")
				// .description("This Rest api is developed application.")
				.version("version - 1.0").license("licence provided by : MCB").contact(new Contact("", "", "")).build();
	}

	// 2. Docket Bean
	@Bean
	public Docket getDocket() {
		log.info("Docket is creating...");
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).forCodeGeneration(true).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}

	@Bean
	  public InternalResourceViewResolver defaultViewResolver() {
	    return new InternalResourceViewResolver();
	  }
	
}