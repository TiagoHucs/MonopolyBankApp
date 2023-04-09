package com.MonopolyBankAppServer.Entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity()
@Table(name = "TB_ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "BALANCE",nullable = false)
    private BigDecimal balance;

    @OneToOne(mappedBy = "account")
    private User owner;

}
