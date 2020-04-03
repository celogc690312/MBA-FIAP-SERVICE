package br.com.fiap.bank.service;

import br.com.fiap.bank.domain.Transaction;
import br.com.fiap.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements  TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public boolean verifyCardBinExists(String cardBin) {
        return transactionRepository.verifyCardBinExists(cardBin);
    }

    public Transaction findTransactionByCardBin(String cardBin) {
        return transactionRepository.findTransactionByCardBin(cardBin);
    }

    public String findCardBin(String cardBin) {

        return transactionRepository.findCardBin(cardBin);
    }

    public void populateDatabase() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(Transaction.builder()
                .id(1L)
                .cardBin("123456789")
                .value(8.0)
                .build());

        transactions.add(Transaction.builder()
                .id(2L)
                .cardBin("987654321")
                .value(10.0)
                .build());

        transactions.add(Transaction.builder()
                .id(3L)
                .cardBin("111222333")
                .value(100.0)
                .build());

        transactions.add(Transaction.builder()
                .id(4L)
                .cardBin("123412341234")
                .value(50.0)
                .build());

        transactionRepository.saveAll(transactions);
    }
}
