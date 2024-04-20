package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.TransactionDTO;
import com.hackathon.prduction.domain.entity.Transaction;
import com.hackathon.prduction.exceptions.transaction.TransactionNotFoundByIdException;

import java.util.List;

public interface TransactionService {
    TransactionDTO createTransaction(Transaction transaction);
    void deleteTransaction(Long transactionId) throws TransactionNotFoundByIdException;
    List<TransactionDTO> getAllTransactions();
    TransactionDTO getOneTransaction(Long transactionId) throws TransactionNotFoundByIdException;
}
