package com.zen.hardwarechallengebackend.hardware.bill.dto;

import com.zen.hardwarechallengebackend.hardware.bill.entity.ProductSold;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Data
public class BillDTO {
    private String id;
    private LocalDate date;
    @NotBlank
    private String customer;
    @NotBlank
    private String seller;
    @NotNull
    private List<ProductSold> productsSold;
    @NotNull
    private Integer total;
}
