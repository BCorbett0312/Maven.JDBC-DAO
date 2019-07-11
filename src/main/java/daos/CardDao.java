package daos;

import models.Card;

import java.util.Set;

public interface CardDao {
    Card getCard(int id);
    Set<Card> getAllCards();
    boolean insertCard(Card card);
    boolean updateCard(Card card);
    boolean deleteCard(int id);


}
