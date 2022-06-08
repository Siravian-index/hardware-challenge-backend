package com.zen.hardwarechallengebackend.hardware.product.dto;

import com.zen.hardwarechallengebackend.hardware.provider.entity.ProviderEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductDTO {
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Integer price;
    @NotNull
    private Integer stock;
    @NotNull
    private Integer max;
    @NotNull
    private Integer min;
    @NotNull
    private ProviderEntity provider;
}
