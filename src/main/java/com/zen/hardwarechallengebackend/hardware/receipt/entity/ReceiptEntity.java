package com.zen.hardwarechallengebackend.hardware.receipt.entity;

import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class ReceiptEntity {
    @Id
    private String id;
    private ProviderEntity provider;
    private String productId;
    private Integer amount;
    private LocalDate date;

}
