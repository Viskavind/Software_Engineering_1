package org.hbrs.se1.ss24.uebung2.Cardbox;

import org.hbrs.se1.ss24.uebung2.businesslogic.DeveloperCard;
import org.hbrs.se1.ss24.uebung2.businesslogic.EndUserCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardBoxTest {

    public CardBox cardBox = new CardBox();
    EndUserCard endUserCard = new EndUserCard("John", "Doe", true);
    DeveloperCard developerCard = new DeveloperCard("Jane", "Doe", false);

    @BeforeEach
    void addPersonCard() {
        try {
            cardBox.addPersonCard(endUserCard);
            cardBox.addPersonCard(developerCard);
        } catch (CardBoxException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deletePersonCard() {
        // Test if the card is deleted from the cardBox
        assertEquals(2, cardBox.size());
        assertEquals("Das CardBox-Objekt mit der ID " + endUserCard.getId() + " wurde erfolgreich gelöscht", cardBox.deletePersonCard(endUserCard.getId()));
        assertEquals(1, cardBox.size());
    }

    @Test
    void showContent() {
        cardBox.showContent();
    }

    @Test
    void size() {
        // Test if the size of the cardBox is returned
        assertEquals(2, cardBox.size());
    }
}