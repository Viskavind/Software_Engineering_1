package org.hbrs.se1.ss24.uebung2.Cardbox;

import org.hbrs.se1.ss24.uebung2.Cardbox.PersonCardView;
import org.hbrs.se1.ss24.uebung2.businesslogic.DeveloperCard;
import org.hbrs.se1.ss24.uebung2.businesslogic.EndUserCard;
import org.hbrs.se1.ss24.uebung2.businesslogic.PersonCard;

import java.io.IOException;
import java.util.ArrayList;

public class Client {

    public static void main(String[] args) throws CardBoxException {

        CardBox cardBox = CardBox.getInstance();
        EndUserCard userJohn = new EndUserCard("John", "Doe", 12345, true);
        DeveloperCard developerJane = new DeveloperCard("Jane", "Dau", 56789, false);
        EndUserCard userMary = new EndUserCard("Mary", "Smith", 24680, false);
        DeveloperCard developerMary = new DeveloperCard("Mary", "Poppins", 13579, true);


        cardBox.addPersonCard(userJohn);
        cardBox.addPersonCard(developerJane);
        cardBox.addPersonCard(userMary);
        cardBox.addPersonCard(developerMary);


        PersonCardView.showContent((ArrayList<PersonCard>) cardBox.getCurrentList());

        try {
            cardBox.save();
        } catch (CardboxStorageException e) {
            throw new RuntimeException(e);
        }

        try {
            cardBox.load();
        } catch (CardboxStorageException e) {
            throw new RuntimeException(e);
        }

        PersonCardView.showContent((ArrayList<PersonCard>) cardBox.getCurrentList());

    }


}
