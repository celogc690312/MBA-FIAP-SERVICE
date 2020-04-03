package br.com.fiap.bank.service;

import br.com.fiap.bank.domain.Transaction;

public interface TransactionService {

    boolean verifyCardBinExists(String cardBin);

    Transaction findTransactionByCardBin(String cardBin);

    String findCardBin(String cardBin);

    void populateDatabase();
}
