package com.zen.hardwarechallengebackend.hardware.product.repository;

import com.zen.hardwarechallengebackend.hardware.product.entity.ProductEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, String> {
}
