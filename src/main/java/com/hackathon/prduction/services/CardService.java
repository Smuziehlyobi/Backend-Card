package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.card.CardRequestDTO;
import com.hackathon.prduction.domain.dto.card.CardResponseDTO;
import com.hackathon.prduction.domain.dto.card.PaymentRequestDTO;
import com.hackathon.prduction.domain.dto.transaction.TransactionResponseDTO;
import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.exceptions.card.CardNotFoundByIdException;
import jakarta.transaction.Transaction;

import java.util.List;

public interface CardService {
    Card createCard(CardRequestDTO card);
    Card createCard(CardRequestDTO card, User user);
    void deleteCard(Long cardId) throws CardNotFoundByIdException;
    List<CardResponseDTO> getAllCards();
    CardResponseDTO getOneCard(Long cardId) throws CardNotFoundByIdException;

    void executePayment(PaymentRequestDTO paymentRequestDTO);

    Card findByUser(User user) ;

    String generateValue();
}
