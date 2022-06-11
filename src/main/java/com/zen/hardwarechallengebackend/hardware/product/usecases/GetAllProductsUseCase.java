package com.zen.hardwarechallengebackend.hardware.product.usecases;

import com.zen.hardwarechallengebackend.hardware.product.dto.ProductDTO;
import com.zen.hardwarechallengebackend.hardware.product.mapper.ProductMapper;
import com.zen.hardwarechallengebackend.hardware.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllProductsUseCase {
    private final ProductRepository repository;

    private final ProductMapper mapper;

    public GetAllProductsUseCase(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public Flux<ProductDTO> apply() {
        return repository.findAll().map(mapper::toDTO);
    }
}
