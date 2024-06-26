package com.hackathon.prduction.repository;

import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> getCardById(Long id);
    Optional<Card> findByValue(String value);
    Optional<Card> findByUser(User user);

}
