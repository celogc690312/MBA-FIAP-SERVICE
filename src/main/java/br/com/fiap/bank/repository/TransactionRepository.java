package br.com.fiap.bank.repository;

import br.com.fiap.bank.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("SELECT count(t.id) > 0 FROM Transaction t WHERE t.cardBin = :cardBin")
    boolean verifyCardBinExists(@Param("cardBin") String cardBin);

    @Query("SELECT t FROM Transaction t WHERE t.cardBin = :cardBin")
    Transaction findTransactionByCardBin(@Param("cardBin") String cardBin);

    @Query("SELECT true FROM Transaction  WHERE card_bin = :cardBin")
    String findCardBin(@Param("cardBin") String cardBin);

}
