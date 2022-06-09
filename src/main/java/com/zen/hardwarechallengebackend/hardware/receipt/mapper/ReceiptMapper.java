package com.zen.hardwarechallengebackend.hardware.receipt.mapper;

import com.zen.hardwarechallengebackend.hardware.receipt.dto.ReceiptDTO;
import com.zen.hardwarechallengebackend.hardware.receipt.entity.ReceiptEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiptMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ReceiptEntity toEntity(ReceiptDTO dto) {
        return modelMapper.map(dto, ReceiptEntity.class);
    }

    public ReceiptDTO toDTO(ReceiptEntity entity) {
        return modelMapper.map(entity, ReceiptDTO.class);
    }
}
