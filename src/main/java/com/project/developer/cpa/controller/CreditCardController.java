package com.project.developer.cpa.controller;

import com.project.developer.cpa.model.CreditCard;
import com.project.developer.cpa.service.CardService;
import com.project.developer.cpa.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CreditCardController {

    private final Logger log = LoggerFactory.getLogger(CreditCardController.class);

    private final CardService cardService;

    public CreditCardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/getCards")
    @ResponseBody
    public ResponseEntity<List<CreditCard>> getCreditCards() {
        log.info("Get all cards from system: getCreditCards");
        return new ResponseEntity(cardService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CreditCard> addCard(@RequestBody CreditCard creditCard) throws Exception {
        log.info("Add new card to system: {}", creditCard);
        CreditCard result = cardService.saveCard(creditCard);
        return ResponseEntity.created(new URI(Constants.REDIRECT_URI + result.getId()))
                .body(result);
    }
}


