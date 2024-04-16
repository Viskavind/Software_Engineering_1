package org.hbrs.se1.ss24.uebung1.client;

import org.hbrs.se1.ss24.uebung1.businesslogic.Objekterzeugung;

public class Client {
    public void printTransformation(int number) {
        String result = Objekterzeugung.Objekt(number);
        System.out.println("Die römische Schreibweise der Zahl " + number + " ist: " + result);
    }
}
