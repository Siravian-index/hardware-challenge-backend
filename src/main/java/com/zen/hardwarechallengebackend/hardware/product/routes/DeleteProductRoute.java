package com.zen.hardwarechallengebackend.hardware.product.routes;

import com.zen.hardwarechallengebackend.hardware.product.usecases.DeleteProductUseCase;
import com.zen.hardwarechallengebackend.hardware.provider.usecases.DeleteProviderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProductRoute {
    @Bean
    @RouterOperation(path = "/v1/api/product/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.DELETE, beanClass = DeleteProductUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "deleteProduct", responses = {
                    @ApiResponse(responseCode = "202", description = "successful operation"),
                    @ApiResponse(responseCode = "404", description = "Employee not found")}, parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id")}
            ))
    public RouterFunction<ServerResponse> deleteOneProductById(DeleteProductUseCase useCase) {
        return route(DELETE("/v1/api/product/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> useCase.apply(request.pathVariable("id"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.NOT_FOUND).build())
                );
    }

}
