package com.zen.hardwarechallengebackend.hardware.bill.usecases;

import com.zen.hardwarechallengebackend.hardware.bill.dto.BillDTO;
import com.zen.hardwarechallengebackend.hardware.bill.entity.ProductSold;
import com.zen.hardwarechallengebackend.hardware.bill.mapper.BillMapper;
import com.zen.hardwarechallengebackend.hardware.bill.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDate;

@Service
@Validated
public class PostBillUseCase {

    @Autowired
    private BillRepository repository;

    @Autowired
    private BillMapper mapper;

    public Mono<BillDTO> apply(@Valid BillDTO dto) {
        dto.setDate(LocalDate.now());
        return repository.save(mapper.toEntity(dto)).map(mapper::toDTO);
    }
}
