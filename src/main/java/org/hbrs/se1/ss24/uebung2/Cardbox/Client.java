package org.hbrs.se1.ss24.uebung2.Cardbox;

import org.hbrs.se1.ss24.uebung2.Cardbox.PersonCardView;
import org.hbrs.se1.ss24.uebung2.businesslogic.DeveloperCard;
import org.hbrs.se1.ss24.uebung2.businesslogic.EndUserCard;

public class Client {

    public static void main(String[] args) throws CardBoxException {

        CardBox cardBox = CardBox.getInstance();
        EndUserCard userJohn = new EndUserCard("John", "Doe", true);
        DeveloperCard developerJane = new DeveloperCard("Jane", "Dau", false);
        EndUserCard userMary = new EndUserCard("Mary", "Smith", false);
        DeveloperCard developerMary = new DeveloperCard("Mary", "Poppins", true);


        cardBox.addPersonCard(userJohn);
        cardBox.addPersonCard(developerJane);
        cardBox.addPersonCard(userMary);
        cardBox.addPersonCard(developerMary);

        PersonCardView.showContent(cardBox.getCurrentList());
    }


}
