package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.transaction.TransactionRequestDTO;
import com.hackathon.prduction.domain.dto.transaction.TransactionResponseDTO;
import com.hackathon.prduction.domain.entity.Transaction;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.exceptions.transaction.TransactionNotFoundByIdException;

import java.util.List;

public interface TransactionService {
    TransactionRequestDTO createTransaction(Transaction transaction);
    void deleteTransaction(Long transactionId) throws TransactionNotFoundByIdException;
    List<TransactionResponseDTO> getAllTransactions();

    public List<TransactionResponseDTO> getAllTransactionsByUser(User user);
    TransactionRequestDTO getOneTransaction(Long transactionId) throws TransactionNotFoundByIdException;
}
