package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.dto.CardDTO;
import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.exceptions.card.CardNotFoundByIdException;

import java.util.List;

public interface CardService {
    CardDTO createCard(Card card);
    void deleteCard(Long cardId) throws CardNotFoundByIdException;
    List<CardDTO> getAllCards();
    CardDTO getOneCard(Long cardId) throws CardNotFoundByIdException;
}
