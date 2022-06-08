package com.zen.hardwarechallengebackend.hardware.product.usecases;

import com.zen.hardwarechallengebackend.hardware.product.mapper.ProductMapper;
import com.zen.hardwarechallengebackend.hardware.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProductUseCase {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    public Mono<Void> apply(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalStateException("Product with " + id + " id does not exist")))
                .flatMap(entity -> repository.deleteById(entity.getId()));
    }
}
