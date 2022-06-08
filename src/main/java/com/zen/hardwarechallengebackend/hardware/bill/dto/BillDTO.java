package com.zen.hardwarechallengebackend.hardware.bill.dto;

import com.zen.hardwarechallengebackend.hardware.bill.entity.ProductSold;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
public class BillDTO {
    private String id;
    private LocalDate date;
    private String customer;
    private String seller;
    private List<ProductSold> productsSold;
    private Integer total;
}
