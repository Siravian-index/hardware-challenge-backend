package com.zen.hardwarechallengebackend.hardware.product.usecases;

import com.zen.hardwarechallengebackend.hardware.product.dto.ProductDTO;
import com.zen.hardwarechallengebackend.hardware.product.entity.ProductEntity;
import com.zen.hardwarechallengebackend.hardware.product.mapper.ProductMapper;
import com.zen.hardwarechallengebackend.hardware.product.repository.ProductRepository;
import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetAllProductsUseCaseTest {

    private GetAllProductsUseCase useCase;
    @Autowired
    private ProductMapper mapper;
    @Mock
    ProductRepository repository;

    @BeforeEach
    void setUp() {
        useCase = new GetAllProductsUseCase(repository, mapper);
    }

    @Test
    void shouldGetAllProviders() {
        ProviderEntity provider1 = new ProviderEntity();
        provider1.setId("1");
        provider1.setName("david");
        provider1.setCard("123");

        ProductEntity productEntity = new ProductEntity();
        productEntity.setStock(0);
        productEntity.setProvider(provider1);
        productEntity.setDescription("a shovel");
        productEntity.setId("testingID");
        productEntity.setMax(50);
        productEntity.setMin(10);
        productEntity.setName("shovel");
        productEntity.setPrice(100);

        Mockito.when(repository.findAll()).thenReturn(Flux.just(productEntity));
        Flux<ProductDTO> productDTOFlux = useCase.apply();

        StepVerifier.create(productDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).findAll();

    }

}