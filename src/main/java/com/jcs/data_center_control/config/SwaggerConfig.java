package com.jcs.data_center_control.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiDoc() {
        return new OpenAPI()
                .info(new Info()
                        .title("Data Center Control API")
                        .description("API de gerenciamento de equipamentos e localizações | Data Center")
                        .version("1.0.0"));
    }
}
