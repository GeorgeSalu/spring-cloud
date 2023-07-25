package br.com.bookservice.configuration;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(
	info = @Info(
			title = "Book service api",
			version = "v1",
			description = "Documentation of book service api"
	)
)
public class OpenApiConfiguration {

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info()
						.title("")
						.version("v1")
						.license(new License()
								.name("Book service api")
								.url("http://springdoc.org")));
	}
	
}
