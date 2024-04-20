package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.card.CardRequestDTO;
import com.hackathon.prduction.domain.dto.card.CardResponseDTO;
import com.hackathon.prduction.domain.dto.card.PaymentRequestDTO;
import com.hackathon.prduction.exceptions.card.CardNotFoundByIdException;

import java.util.List;

public interface CardService {
    CardResponseDTO createCard(CardRequestDTO card);
    void deleteCard(Long cardId) throws CardNotFoundByIdException;
    List<CardResponseDTO> getAllCards();
    CardResponseDTO getOneCard(Long cardId) throws CardNotFoundByIdException;

    void executePayment(PaymentRequestDTO paymentRequestDTO);
}
