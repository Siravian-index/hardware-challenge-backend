package com.zen.hardwarechallengebackend.hardware.bill.usecases;

import com.zen.hardwarechallengebackend.hardware.bill.dto.BillDTO;
import com.zen.hardwarechallengebackend.hardware.bill.mapper.BillMapper;
import com.zen.hardwarechallengebackend.hardware.bill.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllBillsUseCase {

    @Autowired
    private BillRepository repository;

    @Autowired
    private BillMapper mapper;

    public Flux<BillDTO> apply() {
        return repository.findAll().map(mapper::toDTO);
    }
}
