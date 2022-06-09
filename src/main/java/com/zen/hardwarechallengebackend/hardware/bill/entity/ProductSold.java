package com.zen.hardwarechallengebackend.hardware.bill.entity;

import lombok.Data;

@Data
public class ProductSold {
    private String id;
    private String name;
    private Integer price;
    private Integer amount;
}
