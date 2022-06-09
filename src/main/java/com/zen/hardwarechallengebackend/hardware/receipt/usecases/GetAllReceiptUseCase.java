package com.zen.hardwarechallengebackend.hardware.receipt.usecases;

import com.zen.hardwarechallengebackend.hardware.receipt.dto.ReceiptDTO;
import com.zen.hardwarechallengebackend.hardware.receipt.mapper.ReceiptMapper;
import com.zen.hardwarechallengebackend.hardware.receipt.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllReceiptUseCase {
    @Autowired
    private ReceiptMapper mapper;
    @Autowired
    private ReceiptRepository repository;

    public Flux<ReceiptDTO> apply() {
        return repository.findAll().map(mapper::toDTO);
    }
}
