package com.zen.hardwarechallengebackend.hardware.receipt.usecases;

import com.zen.hardwarechallengebackend.hardware.product.dto.ProductDTO;
import com.zen.hardwarechallengebackend.hardware.product.usecases.PostProductUseCase;
import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import com.zen.hardwarechallengebackend.hardware.receipt.dto.ReceiptDTO;
import com.zen.hardwarechallengebackend.hardware.receipt.entity.ReceiptEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class PostReceiptUseCaseTest {

    @MockBean
    PostReceiptUseCase useCase;

    @Test
    void shouldSaveReceipt() {
        ProviderEntity providerEntity = new ProviderEntity();
        providerEntity.setId("1");
        providerEntity.setName("david");
        providerEntity.setCard("1234");

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId("111");

        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setId("receiptID");
        receiptDTO.setProvider(providerEntity);
        receiptDTO.setProductId(productDTO.getId());
        receiptDTO.setAmount(5);
        receiptDTO.setDate(LocalDate.now());



        StepVerifier
                .create(Mono.just(Mockito.when(useCase.apply(receiptDTO))
                        .thenReturn(Mono.just(receiptDTO)))).expectNextCount(1).expectComplete().verify();


    }
}