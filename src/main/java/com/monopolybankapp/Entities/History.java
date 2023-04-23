package com.monopolybankapp.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity()
@Table(name = "TB_HISTORY")
public class History {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "DATE_TIME", updatable = false, nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "ORIGIN_ID", updatable = false)
    private Long originId;

    @Column(name = "ORIGIN_NAME", updatable = false, nullable = false)
    private String originName;

    @Column(name = "DESTINY_ID", updatable = false)
    private Long destinyId;

    @Column(name = "DESTINY_NAME", updatable = false, nullable = false)
    private String destinyName;

    @Column(name = "AMOUNT", updatable = false, nullable = false)
    private BigDecimal amount;


    public void setOrigin(User origin) {
        this.setOriginId(origin.getId());
        this.setOriginName(origin.getUsername());
    }
    public void setDestiny(User destiny) {
        this.setDestinyId(destiny.getId());
        this.setDestinyName(destiny.getUsername());
    }

    @PrePersist
    private void setDateTime(){
        this.dateTime = LocalDateTime.now();
    }

}
