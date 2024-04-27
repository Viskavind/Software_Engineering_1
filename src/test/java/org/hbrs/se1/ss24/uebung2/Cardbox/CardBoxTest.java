package org.hbrs.se1.ss24.uebung2.Cardbox;

import org.hbrs.se1.ss24.uebung2.businesslogic.DeveloperCard;
import org.hbrs.se1.ss24.uebung2.businesslogic.EndUserCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CardBoxTest {

    CardBox cardBox = CardBox.getInstance();
    EndUserCard userJohn = new EndUserCard("John", "Doe", true);
    DeveloperCard developerJane = new DeveloperCard("Jane", "Dau", false);
    EndUserCard userMary = new EndUserCard("Mary", "Smith", false);
    DeveloperCard developerMary = new DeveloperCard("Mary", "Poppins", true);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void createPersonCard() {
        try {
            cardBox.addPersonCard(userJohn);
            cardBox.addPersonCard(developerJane);
        } catch (CardBoxException e) {
            e.printStackTrace();
        }
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void infoTest(){
        assertEquals("John", userJohn.getFirstName());
        assertEquals("Jane", developerJane.getFirstName());
        assertEquals("Doe", userJohn.getLastName());
        assertEquals("Dau", developerJane.getLastName());
        assertNotEquals(userJohn.getFirstName(), developerJane.getFirstName());
        assertNotEquals(userJohn.getLastName(), developerJane.getLastName());
    }

    @Test
    void addPersonCard() {
        //Try to create already existing User
        assertThrows(CardBoxException.class, () -> cardBox.addPersonCard(userJohn));

        //Test create 2 new Objects in CardBox
        try {
            cardBox.addPersonCard(userMary);
        } catch (CardBoxException e) {}
        assertEquals(cardBox.getPersonCard(2), userMary);

        try {
            cardBox.addPersonCard(developerMary);
        } catch (CardBoxException e) {}

        assertEquals(cardBox.getPersonCard(3), developerMary);
        assertEquals(4, cardBox.size());

    }

    @Test
    void deletePersonCard() {
        // Test if the card is deleted from the cardBox

        // Delete non-existent User
        assertEquals("Das CardBox-Objekt mit der ID " + 191919 + " konnte nicht gefunden werden", cardBox.deletePersonCard(191919));

        // Delete exising User
        assertEquals(2, cardBox.size());
        assertEquals("Das CardBox-Objekt mit der ID " + userJohn.getId() + " wurde erfolgreich gelöscht", cardBox.deletePersonCard(userJohn.getId()));
        assertEquals(1, cardBox.size());
    }

    @Test
    void showContent() {
        cardBox.showContent();
        String expectedOutput = userJohn.toString() + System.lineSeparator() + developerJane.toString() + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void size() {
        // Test if the size of the cardBox is returned
        assertEquals(2, cardBox.size());
    }
}