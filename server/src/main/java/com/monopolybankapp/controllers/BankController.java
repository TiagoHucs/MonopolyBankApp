package com.monopolybankapp.controllers;

import com.monopolybankapp.Entities.HomeDetails;
import com.monopolybankapp.config.error.NegocioException;
import com.monopolybankapp.controllers.vo.TransferVO;
import com.monopolybankapp.services.BankService;
import com.monopolybankapp.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest")
public class BankController {

    @Autowired
    private BankService bankService;

    @Autowired
    private Validator accountValidator;

    @GetMapping("home")
    public ResponseEntity<HomeDetails> getBalance() throws NegocioException {
        return ResponseEntity.ok(bankService.getHomeDetails());
    }

    @PostMapping("transfer")
   public ResponseEntity<String> transfer(@RequestBody TransferVO transfer) throws NegocioException {
        accountValidator.tranfer(transfer.getAccountId(),transfer.getValue());
        bankService.transfer(transfer.getAccountId(),transfer.getValue());
        return ResponseEntity.status(HttpStatus.CREATED).body("Transferência realizada com sucesso!");
    }


}
