package com.powermock.api.powermock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private OrderRequest response;
    private String message;
    private int statusCode;
}
