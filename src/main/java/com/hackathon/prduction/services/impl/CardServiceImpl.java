package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.card.CardRequestDTO;
import com.hackathon.prduction.domain.dto.card.CardResponseDTO;
import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.domain.mapper.card.CardRequestMapper;
import com.hackathon.prduction.domain.mapper.card.CardResponseMapper;
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
    private final CardRequestMapper cardRequestMapper;
    private final CardResponseMapper cardResponseMapper;



    @Override
    public CardResponseDTO createCard(CardRequestDTO cardDTO) {
        Card card = cardRequestMapper.toEntity(cardDTO);
        return cardResponseMapper.toDto(cardRepository.save(card));
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
    public List<CardResponseDTO> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        return cardResponseMapper.toDto(cards);
    }

    @Override
    public CardResponseDTO getOneCard(Long cardId) throws CardNotFoundByIdException {
        Card card = cardRepository.findById(cardId).orElse(null);
        if (card == null) {
            throw new CardNotFoundByIdException("Card with such ID does not exist.");
        }
        CardResponseDTO cardResponseDTO = cardResponseMapper.toDto(card);
        return cardResponseDTO;
    }

}
