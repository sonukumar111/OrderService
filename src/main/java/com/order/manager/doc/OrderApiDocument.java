package com.order.manager.doc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class OrderApiDocument {
	private static final Set<String> PRODUCE_CONSUMES=new HashSet<String>(
			  Arrays.asList("application/json","application/xml"));
	
	private static final Contact
	  CONTACT=new Contact("Support ","http://order.support.in","supportforapi@altimetric.com");
	private static final String TITLE="Order Manager API";
	private static final String DESCRIPTION="Rest End points";
	private static final String LICENCE="Apache 1.0";
	
	private ApiInfo orderItemApiInfo() {
		return new ApiInfoBuilder()
				.title(TITLE)
				.description(DESCRIPTION)
				.license(LICENCE)
				.contact(CONTACT)
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.build();
	}
	@Bean
	public Docket apiVersion1_0() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.order.manager.controller"))
				.build()
				 .apiInfo(orderItemApiInfo())
				 .produces(PRODUCE_CONSUMES)
				 .consumes(PRODUCE_CONSUMES);
	}
}
