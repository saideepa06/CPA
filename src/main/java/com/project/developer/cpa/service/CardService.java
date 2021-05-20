package com.project.developer.cpa.service;

import com.project.developer.cpa.model.CreditCard;
import com.project.developer.cpa.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService{

    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CreditCard> findAll(){
        return cardRepository.findAll();
    }

    public CreditCard saveCard(CreditCard creditCard) { return  cardRepository.save(creditCard);}
}
