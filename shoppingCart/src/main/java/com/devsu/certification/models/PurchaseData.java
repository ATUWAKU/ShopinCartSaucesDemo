package com.devsu.certification.models;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseData {

    private List<String> products;
    DeliveryData deliveryData;

}
