package com.zen.hardwarechallengebackend.hardware.bill.routes;

import com.zen.hardwarechallengebackend.hardware.bill.dto.BillDTO;
import com.zen.hardwarechallengebackend.hardware.bill.entity.BillEntity;
import com.zen.hardwarechallengebackend.hardware.bill.usecases.GetAllBillsUseCase;
import com.zen.hardwarechallengebackend.hardware.product.entity.ProductEntity;
import com.zen.hardwarechallengebackend.hardware.product.usecases.GetAllProductsUseCase;
import com.zen.hardwarechallengebackend.hardware.provider.dto.ProviderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllBillsRoute {

    @Bean
    @RouterOperation(path = "/v1/api/bill/", produces = {
            MediaType.APPLICATION_JSON_VALUE},
            beanClass = GetAllBillsUseCase.class, method = RequestMethod.GET, beanMethod = "apply",
            operation = @Operation(operationId = "getBills", responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation",
                            content = @Content(schema = @Schema(implementation = BillEntity.class)))}
            ))
    public RouterFunction<ServerResponse> allBills(GetAllBillsUseCase useCase) {
        return route(GET("/v1/api/bill"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(useCase.apply(), BillDTO.class))
        );

    }
}
