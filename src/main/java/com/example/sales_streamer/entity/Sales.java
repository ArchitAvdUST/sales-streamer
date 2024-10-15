package com.example.sales_streamer.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Sales {

    private String salesId;
    private String productId;
    private String customerId;
    private String quantity;
    private String productName;
    private String salesPerson;
    private String salesDate;
    private String location;
    private String price;
    private String paymentMethod;
    private String transactionId;
    private String status;
    private String additionalInfo;
}
