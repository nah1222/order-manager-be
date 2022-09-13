package config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

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
	public Docket testApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("infy.ordermanager.ordermanager"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
		return new ApiInfo(
				"ordermanager SpringBoot REST API",
				"orderManager SpringBoot REST API for FA4",
				"1.0",
				"Terms of service",
				new Contact("JAVA FA4", "https://infosys.com", "nicholas.ho@infosys.com"),
				"ExpApp License Version 1.0",
				"https://infosys.com",
				Collections.emptyList()	
		);
	}
	
	@SuppressWarnings("unused")
	private void addResourceHandlers(ResourceHandlerRegistry registry){
	
		registry.addResourceHandler("swag-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}