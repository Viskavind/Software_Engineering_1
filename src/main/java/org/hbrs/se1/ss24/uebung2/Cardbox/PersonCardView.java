package org.hbrs.se1.ss24.uebung2.Cardbox;

import org.hbrs.se1.ss24.uebung2.businesslogic.PersonCard;
import java.util.ArrayList;

public class PersonCardView {

    public static void showContent(ArrayList<PersonCard> list){
        for (PersonCard card : list) {
            System.out.println(card.toString());
        }
    }

}
