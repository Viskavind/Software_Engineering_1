package org.hbrs.se1.ss24.uebung2.Cardbox;

import org.hbrs.se1.ss24.uebung2.businesslogic.DeveloperCard;
import org.hbrs.se1.ss24.uebung2.businesslogic.EndUserCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardBoxTest {

    public CardBox cardBox = new CardBox();

    @Test
    void addPersonCard() {
        // Test if the card is added to the cardBox
        try {
            cardBox.addPersonCard(new EndUserCard("John", "Doe", true));
        } catch (CardBoxException e) {
            e.printStackTrace();
        }
        assertEquals(1, cardBox.size());
    }

    @Test
    void deletePersonCard() {
        // Test if the card is deleted from the cardBox
        EndUserCard endUserCard = new EndUserCard("John", "Doe", true);
        try {
            cardBox.addPersonCard(endUserCard);
        } catch (CardBoxException e) {
            e.printStackTrace();
        }
        assertEquals("Das CardBox-Objekt mit der ID "+ endUserCard.getId()+ " wurde erfolgreich gelöscht", cardBox.deletePersonCard(endUserCard.getId()));
    }

    @Test
    void showContent() {
        try {
            cardBox.addPersonCard(new EndUserCard("John", "Doe", true));
            cardBox.addPersonCard(new DeveloperCard("Jane", "Doe", false));
        } catch (CardBoxException e) {
            e.printStackTrace();
        };

        // Test if the content of the cardBox is displayed
        cardBox.showContent();

    }

    @Test
    void size() {
        // Test if the size of the cardBox is returned
        try {
            cardBox.addPersonCard(new EndUserCard("John", "Doe", true));
            cardBox.addPersonCard(new DeveloperCard("Jane", "Doe", false));
        } catch (CardBoxException e) {
            e.printStackTrace();
        }
        assertEquals(2, cardBox.size());
    }
}