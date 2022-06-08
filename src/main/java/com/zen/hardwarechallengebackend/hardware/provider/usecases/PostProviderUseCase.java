package com.zen.hardwarechallengebackend.hardware.provider.usecases;

import com.zen.hardwarechallengebackend.hardware.provider.dto.ProviderDTO;
import com.zen.hardwarechallengebackend.hardware.provider.mapper.ProviderMapper;
import com.zen.hardwarechallengebackend.hardware.provider.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class PostProviderUseCase {

    @Autowired
    private ProviderRepository repository;

    @Autowired
    private ProviderMapper mapper;

    public Mono<ProviderDTO> apply(@Valid ProviderDTO dto) {
        return repository.save(mapper.toEntity(dto)).map(mapper::toDTO);
    }
}
