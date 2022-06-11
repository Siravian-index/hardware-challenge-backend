package com.zen.hardwarechallengebackend.hardware.bill.mapper;

import com.zen.hardwarechallengebackend.hardware.bill.entity.BillDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillMapper {
    @Autowired
    private ModelMapper modelMapper;


    public BillDTO toEntity(com.zen.hardwarechallengebackend.hardware.bill.dto.BillDTO dto) {
        return modelMapper.map(dto, BillDTO.class);
    }

    public com.zen.hardwarechallengebackend.hardware.bill.dto.BillDTO toDTO(BillDTO entity) {
        return modelMapper.map(entity, com.zen.hardwarechallengebackend.hardware.bill.dto.BillDTO.class);
    }
}
