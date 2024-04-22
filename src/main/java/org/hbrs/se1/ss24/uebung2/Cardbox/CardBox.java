package org.hbrs.se1.ss24.uebung2.Cardbox;
import org.hbrs.se1.ss24.uebung2.businesslogic.PersonCard;

import java.util.ArrayList;

public class CardBox {

    private final ArrayList<PersonCard> cardBox = new ArrayList<>();

    public void addPersonCard(PersonCard card) throws CardBoxException {
        for (PersonCard existingCard : cardBox) {
            if (existingCard.getId() == card.getId()) {
                throw new CardBoxException("Das CardBox-Objekt mit der ID " + card.getId() + " ist bereits vorhanden");
            }
        }
        cardBox.add(card);
    }

    public String deletePersonCard(int id){
        for (PersonCard card : cardBox) {
            if (card.getId() == id) {
                cardBox.remove(card);
                return "Das CardBox-Objekt mit der ID " + id + " wurde erfolgreich gelöscht";
            }
        }
        return "Das CardBox-Objekt mit der ID " + id + " konnte nicht gefunden werden";
    }

    public void showContent(){
        for (PersonCard card : cardBox) {
            System.out.println(card.toString());
        }
    }

    public int size(){
        return cardBox.size();
    }
}
