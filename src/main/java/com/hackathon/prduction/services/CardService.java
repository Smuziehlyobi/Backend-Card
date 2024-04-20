package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.card.CardRequestDTO;
import com.hackathon.prduction.domain.dto.card.CardResponseDTO;
import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.exceptions.card.CardNotFoundByIdException;

import java.util.List;
import java.util.Optional;

public interface CardService {
    Card createCard(CardRequestDTO card);
    Card createCard(CardRequestDTO card, User user);
    void deleteCard(Long cardId) throws CardNotFoundByIdException;
    List<CardResponseDTO> getAllCards();
    CardResponseDTO getOneCard(Long cardId) throws CardNotFoundByIdException;

    Card findByUser(User user) ;

    String generateValue();
}
