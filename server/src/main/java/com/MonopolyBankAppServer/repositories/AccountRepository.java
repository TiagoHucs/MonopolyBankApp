package com.MonopolyBankAppServer.repositories;

import com.MonopolyBankAppServer.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
