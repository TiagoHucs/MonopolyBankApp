package com.monopolybankapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class HomeDetails {
    private String clientName;
    private BigDecimal balance;
    private List<History> history;
}
