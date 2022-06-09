package com.zen.hardwarechallengebackend.hardware.receipt.dto;

import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReceiptDTO {
    private String id;
    private ProviderEntity provider;
    private String productId;
    private Integer amount;
    private LocalDate date;
}
