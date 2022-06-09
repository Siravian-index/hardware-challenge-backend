package com.zen.hardwarechallengebackend.hardware.product.routes;

import com.zen.hardwarechallengebackend.hardware.product.dto.ProductDTO;
import com.zen.hardwarechallengebackend.hardware.product.entity.ProductEntity;
import com.zen.hardwarechallengebackend.hardware.product.usecases.PutProductUseCase;
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

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutProductRoute {
    @Bean
    @RouterOperation(path = "/v1/api/product/", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.PUT, beanClass = PutProductUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "updateProduct", responses = {
                    @ApiResponse(responseCode = "202", description = "successful operation", content = @Content(schema = @Schema(implementation = ProductEntity.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid Recipe details supplied")}
                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ProductEntity.class)))
            ))
    public RouterFunction<ServerResponse> updateProduct(PutProductUseCase useCase) {
        return route(PUT("/v1/api/product/").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(useCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto))
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
        );
    }
}
