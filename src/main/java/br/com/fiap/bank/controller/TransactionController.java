package br.com.fiap.bank.controller;

import br.com.fiap.bank.domain.Transaction;
import br.com.fiap.bank.service.TransactionService;
import org.graalvm.compiler.replacements.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.graalvm.compiler.replacements.Log.println;

@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600)
@RestController
@RequestMapping({"/transaction"})
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(path = {"/verify_cardbin_exists/{cardBin}"})
    public Boolean findById(@PathVariable String cardBin){
        System.out.println("-------------------------------------------------");
        System.out.println("/verify_cardbin_exists/" + cardBin);
        System.out.println(transactionService.verifyCardBinExists(cardBin));
        return transactionService.verifyCardBinExists(cardBin);
    }

    @GetMapping(path = {"/retrieve_transaction_by_cardbin/{cardBin}"})
    public Transaction findTransactionByCardBin(@PathVariable String cardBin){
        System.out.println("-------------------------------------------------");
        System.out.println("/retrieve_transaction_by_cardbin/" + cardBin);
        System.out.println(transactionService.findTransactionByCardBin(cardBin));
        return transactionService.findTransactionByCardBin(cardBin);
    }

    @GetMapping(path = {"/retrieve_cardbin_suspeito/{cardBin}"})
    public String findCardBin(@PathVariable String cardBin){
        System.out.println("-------------------------------------------------");
        System.out.println("/retrieve_cardbin_suspeito/"+ cardBin);
        System.out.println(transactionService.findCardBin(cardBin));
        return transactionService.findCardBin(cardBin);
    }
}
