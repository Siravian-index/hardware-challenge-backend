package com.zen.hardwarechallengebackend.hardware.product.usecases;

import com.zen.hardwarechallengebackend.hardware.product.dto.ProductDTO;
import com.zen.hardwarechallengebackend.hardware.provider.dto.ProviderDTO;
import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import com.zen.hardwarechallengebackend.hardware.provider.usecases.PostProviderUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostProductUseCaseTest {


    @MockBean
    PostProductUseCase useCase;


    @Test
    void shouldSaveProvider() {
        ProviderEntity providerEntity = new ProviderEntity();
        providerEntity.setId("1");
        providerEntity.setName("david");
        providerEntity.setCard("1234");

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId("111");
        productDTO.setProvider(providerEntity);
        productDTO.setMax(500);
        productDTO.setMin(100);
        productDTO.setPrice(400);
        productDTO.setName("screws");
        productDTO.setDescription("many screws");
        productDTO.setStock(0);



        StepVerifier
                .create(Mono.just(Mockito.when(useCase.apply(productDTO))
                        .thenReturn(Mono.just(productDTO)))).expectNextCount(1).expectComplete().verify();


    }
}