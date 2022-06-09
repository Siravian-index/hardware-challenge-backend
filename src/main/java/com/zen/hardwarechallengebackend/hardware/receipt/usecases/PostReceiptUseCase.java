package com.zen.hardwarechallengebackend.hardware.receipt.usecases;

import com.zen.hardwarechallengebackend.hardware.receipt.dto.ReceiptDTO;
import com.zen.hardwarechallengebackend.hardware.receipt.mapper.ReceiptMapper;
import com.zen.hardwarechallengebackend.hardware.receipt.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDate;

@Service
@Validated
public class PostReceiptUseCase {
    @Autowired
    private ReceiptMapper mapper;
    @Autowired
    private ReceiptRepository repository;

    public Mono<ReceiptDTO> apply(@Valid ReceiptDTO dto) {
        dto.setDate(LocalDate.now());
        return repository.save(mapper.toEntity(dto)).map(mapper::toDTO);
    }
}
