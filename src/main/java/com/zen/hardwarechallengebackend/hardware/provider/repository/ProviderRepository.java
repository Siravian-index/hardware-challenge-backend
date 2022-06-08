package com.zen.hardwarechallengebackend.hardware.provider.repository;

import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProviderRepository extends ReactiveMongoRepository<ProviderEntity, String> {
}
