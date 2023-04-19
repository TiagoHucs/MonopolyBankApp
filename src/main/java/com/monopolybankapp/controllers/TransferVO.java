package com.monopolybankapp.controllers;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferVO {

    private Long accountId;
    private BigDecimal value;
}
