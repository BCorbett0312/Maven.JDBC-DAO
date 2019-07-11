package daos;

import models.Card;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class CardDTOTest {

    @Test
    public void getCard() {
        CardDTO dto = new CardDTO();
        int id = 1;

        Card thisCard = dto.getCard(id);

        System.out.println(thisCard);



    }

    @Test
    public void getAllCards() {
        CardDTO dto = new CardDTO();

        Set<Card> thisSet = dto.getAllCards();

        for(Card card : thisSet){
            System.out.println(card);
        }

    }

    @Test
    public void insertCard() {
        CardDTO dto = new CardDTO();
        Card toAdd = new Card("Prophetic Prism", 4, "Gatecrash");



        assertTrue(dto.insertCard(toAdd));

    }

    @Test
    public void updateCard() {
        CardDTO dto = new CardDTO();
        Card toUpdate = new Card("Prophetic Prism", 2, "Kaladesh");
        toUpdate.setId(8);


        assertTrue(dto.updateCard(toUpdate));

    }

    @Test
    public void deleteCard() {
        CardDTO dto = new CardDTO();


        assertTrue(dto.deleteCard(7));
    }
}