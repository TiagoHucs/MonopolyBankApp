package com.monopolybankapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class HomeDetails {
    private String clientName;
    private BigDecimal balance;
}
