package com.zen.hardwarechallengebackend.hardware.receipt.dto;

import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ReceiptDTO {
    private String id;
    @NotNull
    private ProviderEntity provider;
    @NotBlank
    private String productId;
    @NotNull
    private Integer amount;
    private LocalDate date;
}
