package com.zen.hardwarechallengebackend.hardware.provider.usecases;

import com.zen.hardwarechallengebackend.hardware.provider.dto.ProviderDTO;
import com.zen.hardwarechallengebackend.hardware.provider.mapper.ProviderMapper;
import com.zen.hardwarechallengebackend.hardware.provider.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllProvidersUseCase {

    private final ProviderRepository repository;

    private final ProviderMapper mapper;

    public GetAllProvidersUseCase(ProviderRepository repository, ProviderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<ProviderDTO> apply() {
        return repository.findAll().map(mapper::toDTO);
    }

}
