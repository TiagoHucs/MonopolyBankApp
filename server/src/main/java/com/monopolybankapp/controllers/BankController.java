package com.monopolybankapp.controllers;

import com.monopolybankapp.Entities.HomeDetails;
import com.monopolybankapp.config.error.NegocioException;
import com.monopolybankapp.controllers.vo.TransferVO;
import com.monopolybankapp.services.BankService;
import com.monopolybankapp.validators.Validator;
import io.swagger.annotations.ApiImplicitParam;
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
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<HomeDetails> getBalance() throws NegocioException {
        return ResponseEntity.ok(bankService.getHomeDetails());
    }

    @PostMapping("transfer")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<String> transfer(@RequestBody TransferVO transfer) throws NegocioException {
        accountValidator.tranfer(transfer.getAccountId(),transfer.getValue());
        bankService.transfer(transfer.getAccountId(),transfer.getValue());
        return ResponseEntity.status(HttpStatus.CREATED).body("Transferência realizada com sucesso!");
    }


}
