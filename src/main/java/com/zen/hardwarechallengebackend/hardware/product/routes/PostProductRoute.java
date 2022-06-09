package com.zen.hardwarechallengebackend.hardware.product.routes;

import com.zen.hardwarechallengebackend.hardware.product.dto.ProductDTO;
import com.zen.hardwarechallengebackend.hardware.product.entity.ProductEntity;
import com.zen.hardwarechallengebackend.hardware.product.usecases.PostProductUseCase;
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
public class PostProductRoute {

    @Bean
    @RouterOperation(path = "/v1/api/product/", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = PostProductUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "createProduct", responses = {
                    @ApiResponse(responseCode = "201", description = "successful operation", content = @Content(schema = @Schema(implementation = ProductEntity.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid Recipe details supplied")}
                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ProductEntity.class)))
            ))
    public RouterFunction<ServerResponse> createProduct(PostProductUseCase useCase) {
        return route(POST("/v1/api/product").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(useCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto)
                        )
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
        );
    }
}
