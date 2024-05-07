package com.coderhouse.swaggerConfig;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
//import io.swagger.v3.oas.models.OpenAPI;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import java.util.List;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API REST Full | JAVA | Coderhouse",
                version = "1.0.0",
                description = "This API REST expose endpoints to manage products, customers"
                        + " and sale orders",
                contact = @Contact(
                        name = "Francisco Gonzalez",
                        email = "fmgarg@gmail.com",
                        url = "https://github.com/fmgarg"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local server"
                )
        }
)
public class OpenApiConfig {
/*    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API REST Full | JAVA | Coderhouse")
                        .version("1.0.0")
                        .description("This API REST expose endpoints to manage products, customers"
                                    + " and sale orders")
                        .contact(new Contact()
                                .name("Francisco Gonzalez")
                                .email("fmgarg@gmail.com")
                                .url("https://github.com/fmgarg")
                        )
                        .servers(List.of(new Server()
                                .url("http://localhost:8080")
                                .description("Local server")
                        ))
                );
    }*/
}
