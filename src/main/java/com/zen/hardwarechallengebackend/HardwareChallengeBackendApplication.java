package com.zen.hardwarechallengebackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hardware Reactive API", version = "1.0.0", description = "Documentation APIs v1.0.0"))
public class HardwareChallengeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HardwareChallengeBackendApplication.class, args);
    }

}
