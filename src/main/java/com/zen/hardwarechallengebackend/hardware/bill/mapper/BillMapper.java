package com.zen.hardwarechallengebackend.hardware.bill.mapper;

import com.zen.hardwarechallengebackend.hardware.bill.dto.BillDTO;
import com.zen.hardwarechallengebackend.hardware.bill.entity.BillEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillMapper {
    @Autowired
    private ModelMapper modelMapper;


    public BillEntity toEntity(BillDTO dto) {
        return modelMapper.map(dto, BillEntity.class);
    }

    public BillDTO toDTO(BillEntity entity) {
        return modelMapper.map(entity, BillDTO.class);
    }
}
