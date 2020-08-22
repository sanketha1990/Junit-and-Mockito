package com.powermock.api.powermock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private int id;
    private String name;
    private int quantity;
    private int price;
    private String emailId;
    private boolean isDiscountable;

}
