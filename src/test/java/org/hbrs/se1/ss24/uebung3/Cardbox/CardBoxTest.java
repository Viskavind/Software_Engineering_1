package org.hbrs.se1.ss24.uebung3.Cardbox;

import org.hbrs.se1.ss24.uebung3.businesslogic.DeveloperCard;
import org.hbrs.se1.ss24.uebung3.businesslogic.EndUserCard;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

class CardBoxTest {

    CardBox cardBox = CardBox.getInstance();
    EndUserCard userJohn = new EndUserCard("John", "Doe", 1, false);
    DeveloperCard developerJane = new DeveloperCard("Jane", "Dau", 2, true);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

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

/*    @Test
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

    }*/

/*    @Test
    void deletePersonCard() {
        // Test if the card is deleted from the cardBox

        // Delete non-existent User
        assertEquals("Das CardBox-Objekt mit der ID " + 191919 + " konnte nicht gefunden werden", cardBox.deletePersonCard(191919));

        // Delete exising User
        assertEquals(2, cardBox.size());
        assertEquals("Das CardBox-Objekt mit der ID " + userJohn.getId() + " wurde erfolgreich gelöscht", cardBox.deletePersonCard(userJohn.getId()));
        assertEquals(1, cardBox.size());
    }*/

    /* @Test
    void showContent() {
        PersonCardView.showContent((ArrayList<PersonCard>) cardBox.getCurrentList());
        String expectedOutput = userJohn.toString() + System.lineSeparator() + developerJane.toString() + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }*/

   /* @Test
    void size() {
        // Test if the size of the cardBox is returned
        assertEquals(2, cardBox.size());
    }*/

    @Test
    void saveTest() throws CardboxStorageException {

        try {
            cardBox.addPersonCard(userJohn);
            cardBox.addPersonCard(developerJane);
            cardBox.save();
        } catch (CardboxStorageException | CardBoxException e) {
            fail("Exception while saving CardBox");

        }

    }

    @Test
    void loadTest() throws CardboxStorageException {
        try {
            cardBox.load();
            assertEquals(2, cardBox.size());
            assertEquals(cardBox.getPersonCard(0).toString(), userJohn.toString());
            assertEquals(cardBox.getPersonCard(1).toString(), developerJane.toString());
        } catch (CardboxStorageException e) {
            fail("Exception while loading CardBox");
        }

    }
}