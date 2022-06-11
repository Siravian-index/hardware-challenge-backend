package com.zen.hardwarechallengebackend.hardware.bill.usecases;

import com.zen.hardwarechallengebackend.hardware.bill.entity.BillDTO;
import com.zen.hardwarechallengebackend.hardware.bill.entity.ProductSold;
import com.zen.hardwarechallengebackend.hardware.bill.mapper.BillMapper;
import com.zen.hardwarechallengebackend.hardware.bill.repository.BillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest

class GetAllBillsUseCaseTest {
    private GetAllBillsUseCase useCase;
    @Autowired
    private BillMapper mapper;
    @Mock
    BillRepository repository;

    @BeforeEach
    void setUp() {
        useCase = new GetAllBillsUseCase(repository, mapper);
    }


    @Test
    void shouldGetAllBIll() {
        ProductSold productSold1 = new ProductSold();
        productSold1.setId("1");
        productSold1.setPrice(50);
        productSold1.setName("table");
        productSold1.setAmount(4);
        ProductSold productSold2 = new ProductSold();
        productSold2.setId("1");
        productSold2.setPrice(50);
        productSold2.setName("table");
        productSold2.setAmount(4);

        BillDTO billEntity = new BillDTO();
        billEntity.setId("testID");
        billEntity.setDate(LocalDate.now());
        billEntity.setCustomer("Mario");
        billEntity.setSeller("Raul");
        billEntity.setProductsSold(List.of(productSold1, productSold2));
        billEntity.setTotal(1000);

        Mockito.when(repository.findAll()).thenReturn(Flux.just(billEntity));
        Flux<com.zen.hardwarechallengebackend.hardware.bill.dto.BillDTO> billDTOFlux = useCase.apply();

        StepVerifier.create(billDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }
}