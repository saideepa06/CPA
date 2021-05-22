package com.project.developer.cpa.controller;

import com.project.developer.cpa.CpaService;
import com.project.developer.cpa.exception.CpaInternalException;
import com.project.developer.cpa.model.CreditCard;
import com.project.developer.cpa.repository.CardRepository;
import com.project.developer.cpa.service.CardService;
import com.project.developer.cpa.util.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = CpaService.class)
@TestPropertySource({"classpath:application.properties"})
@EnableConfigurationProperties
public class CreditCardControllerTest {

    @Mock
    CardRepository cardRepository;

    @Mock
    CardService cardService;

    @InjectMocks
    private CreditCardController creditCardController;

    @BeforeEach
    public void setUp() {
        cardService = new CardService(cardRepository);
        creditCardController = new CreditCardController(cardService);
    }

    @Test
    public void testAddSuccess() throws Exception {

        CreditCard cc = TestHelper.getSuccessCreditCard();
        Mockito.when(cardService.saveCard(cc)).thenReturn(cc);
        ResponseEntity<CreditCard> card = creditCardController.addCard(cc);
        assertEquals(HttpStatus.CREATED.value(), card.getStatusCodeValue());
    }

    @Test
    public void testAddThrows() {

        assertThrows(CpaInternalException.class, () -> creditCardController.addCard(TestHelper.getFailureCreditCard()));
    }


    @Test
    public void testGetSuccess() {

        CreditCard cc = TestHelper.getSuccessCreditCard();
        Mockito.when(cardService.findAll()).thenReturn(List.of(cc));
        ResponseEntity<List<CreditCard>> cardList = creditCardController.getCreditCards();
        assertEquals(HttpStatus.OK.value(), cardList.getStatusCode().value());
    }

}
