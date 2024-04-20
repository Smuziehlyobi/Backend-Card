package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.CardDTO;
import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.domain.mapper.CardMapper;
import com.hackathon.prduction.exceptions.card.CardNotFoundByIdException;
import com.hackathon.prduction.services.CardService;
import com.hackathon.prduction.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;



    @Override
    public CardDTO createCard(Card card) {
        CardDTO cardDTO = cardMapper.toDto(card);
        cardRepository.save(card);
        return cardDTO;
    }

    @Override
    public void deleteCard(Long cardId) throws CardNotFoundByIdException {
        Card card = cardRepository.findById(cardId).orElse(null);
        if (card == null) {
            throw new CardNotFoundByIdException("Card with such ID does not exist.");
        }
        cardRepository.delete(card);
    }

    @Override
    public List<CardDTO> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        List<CardDTO> cardDTOs = cardMapper.toDto(cards);
        return cardDTOs;
    }

    @Override
    public CardDTO getOneCard(Long cardId) throws CardNotFoundByIdException {
        Card card = cardRepository.findById(cardId).orElse(null);
        if (card == null) {
            throw new CardNotFoundByIdException("Card with such ID does not exist.");
        }
        CardDTO cardDTO = cardMapper.toDto(card);
        return cardDTO;
    }

}
