package com.zen.hardwarechallengebackend.hardware.product.usecases;

import com.zen.hardwarechallengebackend.hardware.product.dto.ProductDTO;
import com.zen.hardwarechallengebackend.hardware.product.mapper.ProductMapper;
import com.zen.hardwarechallengebackend.hardware.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
public class PostProductUseCase {
    private final ProductRepository repository;

    private final ProductMapper mapper;

    public PostProductUseCase(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Mono<ProductDTO> apply(@Valid ProductDTO dto) {
        return repository.save(mapper.toEntity(dto)).map(mapper::toDTO);
    }
}
