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

    @Column
    private LocalDateTime dateTime;

    @Column
    private Long originId;

    @Column
    private Long destinyId;

    @Column
    private BigDecimal value;


}
