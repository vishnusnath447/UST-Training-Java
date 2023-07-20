package in.stackroute.ust;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    public OpenAPI openAPI(){
        Info info = new Info().title("USER CRUD Operations")
                .description("User details can be saved, updated, read and be deleted")
                .version("1.0.0");
        return new OpenAPI().info(info);
    }
}