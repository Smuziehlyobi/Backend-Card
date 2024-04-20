package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.card.CardRequestDTO;
import com.hackathon.prduction.domain.dto.card.CardResponseDTO;
import com.hackathon.prduction.domain.entity.Card;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.domain.mapper.card.CardRequestMapper;
import com.hackathon.prduction.domain.mapper.card.CardResponseMapper;
import com.hackathon.prduction.exceptions.card.CardNotFoundByIdException;
import com.hackathon.prduction.services.CardService;
import com.hackathon.prduction.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardRequestMapper cardRequestMapper;
    private final CardResponseMapper cardResponseMapper;



    @Override
    public Card createCard(CardRequestDTO cardDTO) {
        Card card = cardRequestMapper.toEntity(cardDTO);
        cardRepository.save(card);
        return card;
    }

    @Override
    public Card createCard(CardRequestDTO cardDTO, User user) {
        Card card = cardRequestMapper.toEntity(cardDTO);
        cardRepository.save(card);
        return card;
    }


    @Override
    public Card findByUser (User user)  {
       Card card = cardRepository.findByUser(user).orElseThrow(() -> new CardNotFoundByIdException("Card with such ID does not exist."));
       return card;
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

    @Override
    public String generateValue() {
        String value = generateCardNumber();
        Optional<Card> card = cardRepository.findByValue( value);
        while (card.isPresent()){
            value = generateCardNumber();
            card = cardRepository.findByValue(value);
        }

        return value;
    }

    private String generateCardNumber() {
        StringBuilder value = new StringBuilder();
        Random rand = new Random();
        int count = 0;
        for (int i = 0; i < 19; i++) {
            if(count == 4){
                value.append(" ");
                count = 0;
            }else {
                int n = rand.nextInt(10);
                value.append(n);
                count++;
            }
        }
        return value.toString();
    }


}
