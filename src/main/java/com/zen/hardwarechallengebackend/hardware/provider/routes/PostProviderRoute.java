package com.zen.hardwarechallengebackend.hardware.provider.routes;

import com.zen.hardwarechallengebackend.hardware.provider.dto.ProviderDTO;
import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import com.zen.hardwarechallengebackend.hardware.provider.usecases.PostProviderUseCase;
import com.zen.hardwarechallengebackend.hardware.receipt.entity.ReceiptEntity;
import com.zen.hardwarechallengebackend.hardware.receipt.usecases.PostReceiptUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostProviderRoute {

    @Bean
    @RouterOperation(path = "/v1/api/provider/", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = PostProviderUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "createProvider", responses = {
                    @ApiResponse(responseCode = "201", description = "successful operation", content = @Content(schema = @Schema(implementation = ProviderEntity.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid Recipe details supplied")}
                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ProviderEntity.class)))
            ))
    public RouterFunction<ServerResponse> createProvider(PostProviderUseCase useCase) {
        return route(POST("/v1/api/provider").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderDTO.class)
                        .flatMap(useCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto)
                        )
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
        );
    }
}

