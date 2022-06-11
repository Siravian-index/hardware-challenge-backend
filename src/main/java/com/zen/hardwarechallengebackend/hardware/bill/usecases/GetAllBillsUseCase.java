package com.zen.hardwarechallengebackend.hardware.bill.usecases;

import com.zen.hardwarechallengebackend.hardware.bill.dto.BillDTO;
import com.zen.hardwarechallengebackend.hardware.bill.mapper.BillMapper;
import com.zen.hardwarechallengebackend.hardware.bill.repository.BillRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllBillsUseCase {

    private final BillRepository repository;

    private final BillMapper mapper;

    public GetAllBillsUseCase(BillRepository repository, BillMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Flux<BillDTO> apply() {
        return repository.findAll().map(mapper::toDTO);
    }
}
