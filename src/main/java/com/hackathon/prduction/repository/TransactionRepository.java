package com.hackathon.prduction.repository;

import com.hackathon.prduction.domain.entity.Transaction;
import com.hackathon.prduction.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByUser(User user);
}
