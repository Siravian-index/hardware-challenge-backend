package com.zen.hardwarechallengebackend.hardware.receipt.usecases;

import com.zen.hardwarechallengebackend.hardware.receipt.dto.ReceiptDTO;
import com.zen.hardwarechallengebackend.hardware.receipt.mapper.ReceiptMapper;
import com.zen.hardwarechallengebackend.hardware.receipt.repository.ReceiptRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllReceiptUseCase {
    private final ReceiptMapper mapper;
    private final ReceiptRepository repository;

    public GetAllReceiptUseCase(ReceiptRepository repository, ReceiptMapper mapper) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public Flux<ReceiptDTO> apply() {
        return repository.findAll().map(mapper::toDTO);
    }
}
