package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.transaction.TransactionRequestDTO;
import com.hackathon.prduction.domain.entity.Transaction;
import com.hackathon.prduction.exceptions.transaction.TransactionNotFoundByIdException;

import java.util.List;

public interface TransactionService {
    TransactionRequestDTO createTransaction(Transaction transaction);
    void deleteTransaction(Long transactionId) throws TransactionNotFoundByIdException;
    List<TransactionRequestDTO> getAllTransactions();
    TransactionRequestDTO getOneTransaction(Long transactionId) throws TransactionNotFoundByIdException;
}
