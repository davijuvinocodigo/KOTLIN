package com.livros.config;


import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun apiPublica(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("livros-service")
            .pathsToMatch("/**")
            .build()
    }

    @Bean
    fun openAPICustomizado(
        @Value("API para gerenciamento de livros e clientes") descricao: String,
        @Value("1.0.0") versao: String
    ): OpenAPI {
        val contato = Contact()
        contato.email = "contato@exemplo.com"
        contato.name = "Equipe de Desenvolvimento"
        contato.url = "https://www.exemplo.com"

        return OpenAPI()
            .info(
                Info()
                    .title("API de Gerenciamento de Livros")
                    .version(versao)
                    .description(descricao)
                    .termsOfService("http://swagger.io/terms/")
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
                    .contact(contato)
            )
    }
}