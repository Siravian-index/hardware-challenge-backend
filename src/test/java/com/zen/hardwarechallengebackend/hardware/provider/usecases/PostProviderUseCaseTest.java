package com.zen.hardwarechallengebackend.hardware.provider.usecases;

import com.zen.hardwarechallengebackend.hardware.provider.dto.ProviderDTO;
import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import com.zen.hardwarechallengebackend.hardware.provider.repository.ProviderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostProviderUseCaseTest {


    @MockBean
    PostProviderUseCase useCase;

    @Mock
    ProviderRepository repository;


    @Test
    void shouldSaveProvider() {
        ProviderDTO providerDTO = new ProviderDTO();
        providerDTO.setId("1");
        providerDTO.setName("david");
        providerDTO.setCard("1234");


        StepVerifier
                .create(Mono.just(Mockito.when(useCase.apply(providerDTO))
                        .thenReturn(Mono.just(providerDTO)))).expectNextCount(1).expectComplete().verify();


    }

}