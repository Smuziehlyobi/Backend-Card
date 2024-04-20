package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.transaction.TransactionRequestDTO;
import com.hackathon.prduction.domain.entity.Transaction;
import com.hackathon.prduction.domain.mapper.transaction.TransactionMapper;
import com.hackathon.prduction.exceptions.transaction.TransactionNotFoundByIdException;
import com.hackathon.prduction.repository.TransactionRepository;
import com.hackathon.prduction.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;


    @Override
    public TransactionRequestDTO createTransaction(Transaction transaction) {
        TransactionRequestDTO transactionRequestDTO = transactionMapper.toDto(transaction);
        transactionRepository.save(transaction);
        return transactionRequestDTO;
    }

    @Override
    public void deleteTransaction(Long transactionId) throws TransactionNotFoundByIdException {
        Transaction transaction = transactionRepository.findById(transactionId).orElse(null);
        if(transaction == null){
            throw new TransactionNotFoundByIdException("Transaction with such ID does not exist.");
        }
        transactionRepository.delete(transaction);
    }

    @Override
    public List<TransactionRequestDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionRequestDTO> transactionRequestDTOS = transactionMapper.toDto(transactions);
        return transactionRequestDTOS;
    }

    @Override
    public TransactionRequestDTO getOneTransaction(Long transactionId) throws TransactionNotFoundByIdException {
        Transaction transaction = transactionRepository.findById(transactionId).orElse(null);
        if(transaction == null) {
            throw new TransactionNotFoundByIdException("Transaction with such ID does not exist.");
        }
        TransactionRequestDTO transactionRequestDTO = transactionMapper.toDto(transaction);
        return transactionRequestDTO;
    }

}
