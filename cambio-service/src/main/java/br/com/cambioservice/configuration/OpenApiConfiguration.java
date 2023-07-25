package br.com.cambioservice.configuration;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(
	info = @Info(
			title = "CAmbio service api",
			version = "v1",
			description = "Documentation of cambio service api"
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
								.name("cambio service api")
								.url("http://springdoc.org")));
	}
	
}