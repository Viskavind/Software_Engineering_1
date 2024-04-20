package org.hbrs.se1.ss24.uebung2.Cardbox;
import org.hbrs.se1.ss24.uebung2.businesslogic.PersonCardAbstract;

import java.util.ArrayList;

public class CardBox {

    private final ArrayList<PersonCardAbstract> cardBox = new ArrayList<>();

    public void addPersonCard(PersonCardAbstract card) throws CardBoxException {
        for (PersonCardAbstract existingCard : cardBox) {
            if (existingCard.getId() == card.getId()) {
                throw new CardBoxException("Das CardBox-Objekt mit der ID " + card.getId() + " ist bereits vorhanden");
            }
        }
        cardBox.add(card);
    }

    public String deletePersonCard(int id){
        for (PersonCardAbstract card : cardBox) {
            if (card.getId() == id) {
                cardBox.remove(card);
                return "Das CardBox-Objekt mit der ID " + id + " wurde erfolgreich gelöscht";
            }
        }
        return "Das CardBox-Objekt mit der ID " + id + " konnte nicht gefunden werden";
    }

    public void showContent(){
        for (PersonCardAbstract card : cardBox) {
            System.out.println(card.toString());
        }
    }

    public int size(){
        return cardBox.size();
    }
}
