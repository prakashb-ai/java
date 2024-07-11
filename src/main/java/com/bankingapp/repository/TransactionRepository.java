package com.bankingapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bankingapp.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySenderAccount_AccountNumberOrRecipientAccount_AccountNumber(String senderAccountNumber, String recipientAccountNumber);
}
