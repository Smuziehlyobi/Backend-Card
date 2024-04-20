package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.TransactionDTO;
import com.hackathon.prduction.domain.entity.Transaction;
import com.hackathon.prduction.domain.mapper.TransactionMapper;
import com.hackathon.prduction.exceptions.transaction.TransactionNotFoundByIdException;
import com.hackathon.prduction.repository.TransactionRepository;
import com.hackathon.prduction.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;


    @Override
    public TransactionDTO createTransaction(Transaction transaction) {
        TransactionDTO transactionDTO = transactionMapper.toDto(transaction);
        transactionRepository.save(transaction);
        return transactionDTO;
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
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDTO> transactionDTOs = transactionMapper.toDto(transactions);
        return transactionDTOs;
    }

    @Override
    public TransactionDTO getOneTransaction(Long transactionId) throws TransactionNotFoundByIdException {
        Transaction transaction = transactionRepository.findById(transactionId).orElse(null);
        if(transaction == null) {
            throw new TransactionNotFoundByIdException("Transaction with such ID does not exist.");
        }
        TransactionDTO transactionDTO = transactionMapper.toDto(transaction);
        return transactionDTO;
    }

}
