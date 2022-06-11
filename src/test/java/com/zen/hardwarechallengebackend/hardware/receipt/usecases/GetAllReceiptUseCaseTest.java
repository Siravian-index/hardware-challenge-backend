package com.zen.hardwarechallengebackend.hardware.receipt.usecases;

import com.zen.hardwarechallengebackend.hardware.product.entity.ProductEntity;
import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import com.zen.hardwarechallengebackend.hardware.receipt.dto.ReceiptDTO;
import com.zen.hardwarechallengebackend.hardware.receipt.entity.ReceiptEntity;
import com.zen.hardwarechallengebackend.hardware.receipt.mapper.ReceiptMapper;
import com.zen.hardwarechallengebackend.hardware.receipt.repository.ReceiptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDate;

@SpringBootTest
class GetAllReceiptUseCaseTest {
    private GetAllReceiptUseCase useCase;
    @Autowired
    private ReceiptMapper mapper;
    @Mock
    ReceiptRepository repository;

    @BeforeEach
    void setUp() {
        useCase = new GetAllReceiptUseCase(repository, mapper);
    }

    @Test
    void shouldGetAllReceipts() {
        ProviderEntity provider1 = new ProviderEntity();
        provider1.setId("1");
        provider1.setName("david");
        provider1.setCard("123");

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId("testingID");

        ReceiptEntity receiptEntity = new ReceiptEntity();
        receiptEntity.setId("receiptID");
        receiptEntity.setProvider(provider1);
        receiptEntity.setProductId(productEntity.getId());
        receiptEntity.setAmount(5);
        receiptEntity.setDate(LocalDate.now());

        Mockito.when(repository.findAll()).thenReturn(Flux.just(receiptEntity));
        Flux<ReceiptDTO> receiptDTOFlux = useCase.apply();

        StepVerifier.create(receiptDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }
}