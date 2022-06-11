package com.zen.hardwarechallengebackend.hardware.bill.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document
public class BillDTO {
    @Id
    private String id;
    private LocalDate date;
    private String customer;
    private String seller;
    private List<ProductSold> productsSold;
    private Integer total;
}