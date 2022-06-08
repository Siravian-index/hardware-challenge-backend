package com.zen.hardwarechallengebackend.hardware.provider.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProviderDTO {
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String card;
}
