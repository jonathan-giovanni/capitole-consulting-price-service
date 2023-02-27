package com.capitoleconsulting.price.service.infrastructure.web.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;


/**
 * @author Jonathan Giovanni Hernandez
 * @created 27/02/2023
 */
@Configuration
public class SwaggerDocumentation {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("CAPITOLE-CONSULTING-PRICE-SERVICE").description(
                        "Price microservice API doc by OpenAPI 3.").version("1.0.0"));
    }


}
