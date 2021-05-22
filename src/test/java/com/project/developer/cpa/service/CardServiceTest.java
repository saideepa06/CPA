package com.project.developer.cpa.service;

import com.project.developer.cpa.CpaService;
import com.project.developer.cpa.exception.CpaInternalException;
import com.project.developer.cpa.model.CreditCard;
import com.project.developer.cpa.repository.CardRepository;
import com.project.developer.cpa.util.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = CpaService.class)
@TestPropertySource({"classpath:application.properties"})
@EnableConfigurationProperties
public class CardServiceTest {

    @Mock
    CardRepository cardRepository;

    @InjectMocks
    CardService cardService;

    @BeforeEach
    public void setUp() {
        cardService = new CardService(cardRepository);
    }

    @Test
    public void testAddSuccess() {

        CreditCard cc = TestHelper.getSuccessCreditCard();
        Mockito.when(cardRepository.save(cc)).thenReturn(cc);
        CreditCard card = cardService.saveCard(cc);
        assertEquals(cc, card);
    }

    @Test
    public void testAddThrows() {

        assertThrows(CpaInternalException.class, () -> cardService.saveCard(TestHelper.getFailureCreditCard()));
    }


    @Test
    public void testGetSuccess() {

        CreditCard cc = TestHelper.getSuccessCreditCard();
        Mockito.when(cardRepository.findAll()).thenReturn(List.of(cc));
        List<CreditCard> cardList = cardService.findAll();
        assertEquals(List.of(cc), cardList);
    }

    @Test
    public void testLuhn() {
        List<Long> testList = List.of(79927398710L, 79927398711L, 79927398712L, 79927398713L, 79927398714L, 79927398715L, 79927398716L, 79927398717L, 79927398718L, 79927398719L);
        testList.stream().filter(p -> cardService.validateCard(String.valueOf(p))).findFirst().get();
        assertEquals(79927398713L, testList.stream().filter(p -> cardService.validateCard(String.valueOf(p))).findFirst().get());

    }


}
