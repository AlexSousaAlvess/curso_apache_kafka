package com.alex.paymentservice.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Payment implements Serializable {
    private long id;
    private long idUser;
    private long idProduct;
    private String cardNumber;
}
