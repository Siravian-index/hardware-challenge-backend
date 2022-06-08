package com.zen.hardwarechallengebackend.hardware.provider.usecases;

import com.zen.hardwarechallengebackend.hardware.provider.mapper.ProviderMapper;
import com.zen.hardwarechallengebackend.hardware.provider.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProviderUseCase {
    @Autowired
    private ProviderRepository repository;

    @Autowired
    private ProviderMapper mapper;

    public Mono<Void> apply(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalStateException("Provider with " + id + " id does not exist")))
                .flatMap(entity -> repository.deleteById(entity.getId()));
    }
}
