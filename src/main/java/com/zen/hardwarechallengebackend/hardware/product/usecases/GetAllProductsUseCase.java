package com.zen.hardwarechallengebackend.hardware.product.usecases;

import com.zen.hardwarechallengebackend.hardware.product.dto.ProductDTO;
import com.zen.hardwarechallengebackend.hardware.product.mapper.ProductMapper;
import com.zen.hardwarechallengebackend.hardware.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllProductsUseCase {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    public Flux<ProductDTO> apply() {
        return repository.findAll().map(mapper::toDTO);
    }
}
