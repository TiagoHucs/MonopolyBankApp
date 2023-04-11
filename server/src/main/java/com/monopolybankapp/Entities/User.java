package com.monopolybankapp.Entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity()
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT", referencedColumnName = "ID")
    private Account account;

    public <E> User(String username,String password) {
        this.username = username;
        this.password = password;
    }
}
