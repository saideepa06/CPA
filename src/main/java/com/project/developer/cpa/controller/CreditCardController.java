package com.project.developer.cpa.controller;

import com.project.developer.cpa.exception.CpaException;
import com.project.developer.cpa.model.CreditCard;
import com.project.developer.cpa.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("api/v1")
public class CreditCardController {

    private final Logger log = LoggerFactory.getLogger(CreditCardController.class);

    private CardService cardService;

    public CreditCardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/getCards")
    Collection<CreditCard> getCreditCards() {
        return cardService.findAll();
    }

    @PostMapping("/add")
    ResponseEntity<CreditCard> addCard(@RequestBody CreditCard creditCard) throws CpaException, URISyntaxException {
        log.info("Add new card to system: {}", creditCard);
        CreditCard result = cardService.saveCard(creditCard);
        return ResponseEntity.created(new URI("/api/add/" + result.getId()))
                .body(result);
    }
}


