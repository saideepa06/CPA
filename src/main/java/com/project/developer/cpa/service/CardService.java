package com.project.developer.cpa.service;

import com.project.developer.cpa.model.CreditCard;
import com.project.developer.cpa.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService{

    @Autowired
    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CreditCard> findAll(){
        return cardRepository.findAll();
    }

    public CreditCard saveCard(CreditCard creditCard) {
       return (validateCard(String.valueOf(creditCard.getCreditCardNumber()))) ?  cardRepository.save(creditCard) :  null;
    }

   public boolean validateCard(String cardNumber) {
        int count= 0;
        for(int i=cardNumber.length()-1; i>=0; i--){
                int let = cardNumber.charAt(i) - '0';
            if(i%2==0) {
                if (let * 2 <= 10) {
                    count = count + (let * 2);
                } else {
                    count = count + (let * 2) % 10 + (let * 2) / 10;
                }
            }else{
                count = count + let;
            }
        }
        return(count%10 == 0);
    }

}
