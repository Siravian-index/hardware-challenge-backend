package com.zen.hardwarechallengebackend.hardware.product.routes;

import com.zen.hardwarechallengebackend.hardware.product.usecases.GetAllProductsUseCase;
import com.zen.hardwarechallengebackend.hardware.provider.dto.ProviderDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProductsRoute {
    @Bean
    public RouterFunction<ServerResponse> allProducts(GetAllProductsUseCase useCase) {
        return route(GET("/v1/api/product"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(useCase.apply(), ProviderDTO.class))
        );

    }
}
