package org.deacasa.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfig {

    @Bean
    public OpenAPI customOperAPI(){
        return  new OpenAPI()
                .info(new Info().title("de-acasa").version("1.0").description("API for web-site DeAcasa"));
    }
}
