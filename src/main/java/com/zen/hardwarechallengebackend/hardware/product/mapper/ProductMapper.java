package com.zen.hardwarechallengebackend.hardware.product.mapper;

import com.zen.hardwarechallengebackend.hardware.product.dto.ProductDTO;
import com.zen.hardwarechallengebackend.hardware.product.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductEntity toEntity(ProductDTO dto) {
        return modelMapper.map(dto, ProductEntity.class);
    }

    public ProductDTO toDTO(ProductEntity entity) {
        return modelMapper.map(entity, ProductDTO.class);
    }
}

