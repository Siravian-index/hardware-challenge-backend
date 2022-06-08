package com.zen.hardwarechallengebackend.hardware.bill.repository;

import com.zen.hardwarechallengebackend.hardware.bill.entity.BillEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BillRepository extends ReactiveMongoRepository<BillEntity, String> {
}
