package com.zen.hardwarechallengebackend.hardware.provider.usecases;

import com.zen.hardwarechallengebackend.hardware.provider.dto.ProviderDTO;
import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import com.zen.hardwarechallengebackend.hardware.provider.mapper.ProviderMapper;
import com.zen.hardwarechallengebackend.hardware.provider.repository.ProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllProvidersUseCaseTest {


    private GetAllProvidersUseCase useCase;
    @Autowired
    private ProviderMapper mapper;
    @Mock
    ProviderRepository repository;


    @BeforeEach
    void setUp() {
        useCase = new GetAllProvidersUseCase(repository, mapper);
    }


    @Test
    void shouldGetAllProviders() {
        ProviderEntity provider1 = new ProviderEntity();
        ProviderEntity provider2 = new ProviderEntity();
        provider1.setId("1");
        provider2.setId("2");
        provider1.setName("david");
        provider2.setName("juan");
        provider1.setCard("123");
        provider2.setCard("456");

        Mockito.when(repository.findAll()).thenReturn(Flux.just(provider1, provider2));
        Flux<ProviderDTO> providerDTOFlux = useCase.apply();

        StepVerifier.create(providerDTOFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(repository).findAll();

    }
}