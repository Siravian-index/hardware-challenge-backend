package com.zen.hardwarechallengebackend.hardware.receipt.repository;

import com.zen.hardwarechallengebackend.hardware.receipt.entity.ReceiptEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReceiptRepository extends ReactiveMongoRepository<ReceiptEntity, String> {
}
