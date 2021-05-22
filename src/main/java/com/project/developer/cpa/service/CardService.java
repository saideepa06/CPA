package com.project.developer.cpa.service;

import com.project.developer.cpa.exception.CpaInternalException;
import com.project.developer.cpa.model.CreditCard;
import com.project.developer.cpa.repository.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final Logger log = LoggerFactory.getLogger(CardService.class);

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CreditCard> findAll() {
        log.info("Get all cards from system: findAll");
        return cardRepository.findAll();
    }

    public CreditCard saveCard(CreditCard creditCard) throws CpaInternalException {
        log.info("Service - Get all cards from system: {}", creditCard);
        if (creditCard != null && validateCard(creditCard.getCreditCardNumber().toString())) {
            creditCard.setBalance(0L);
            return cardRepository.save(creditCard);
        } else {
            throw new CpaInternalException("Please Enter a valid Credit Card Details");
        }
    }

    public boolean validateCard(String cardNumber) {
        //Luhn 10
        int count = 0;
        boolean digit = false;

        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int let = cardNumber.charAt(i) - '0';
            if (digit == true)
                let = let * 2;

            count += let / 10;
            count += let % 10;
            digit = !digit;

        }
        return (count % 10 == 0);
    }

}
