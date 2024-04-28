package org.hbrs.se1.ss24.uebung3.Cardbox;

import org.hbrs.se1.ss24.uebung3.businesslogic.DeveloperCard;
import org.hbrs.se1.ss24.uebung3.businesslogic.EndUserCard;
import org.hbrs.se1.ss24.uebung3.businesslogic.PersonCard;

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

    }


}
