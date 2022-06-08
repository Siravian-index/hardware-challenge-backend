package com.zen.hardwarechallengebackend.hardware.provider.mapper;

import com.zen.hardwarechallengebackend.hardware.provider.dto.ProviderDTO;
import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapper {
    private final ModelMapper modelMapper;

    public ProviderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProviderEntity toEntity(ProviderDTO dto) {
        return modelMapper.map(dto, ProviderEntity.class);
    }

    public ProviderDTO toDTO(ProviderEntity entity) {
        return modelMapper.map(entity, ProviderDTO.class);
    }
}
