package com.zen.hardwarechallengebackend.hardware.product.entity;

import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private Integer price;
    private Integer stock;
    private Integer max;
    private Integer min;
    private ProviderEntity provider;

}
