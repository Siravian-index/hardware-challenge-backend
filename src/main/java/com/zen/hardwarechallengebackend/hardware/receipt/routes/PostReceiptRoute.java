package com.zen.hardwarechallengebackend.hardware.receipt.routes;

import com.zen.hardwarechallengebackend.hardware.receipt.dto.ReceiptDTO;
import com.zen.hardwarechallengebackend.hardware.receipt.usecases.PostReceiptUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostReceiptRoute {
    @Bean
    public RouterFunction<ServerResponse> generateReceipt(PostReceiptUseCase useCase) {
        return route(POST("/v1/api/receipt").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ReceiptDTO.class)
                        .flatMap(useCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto)
                        )
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
        );
    }
}
