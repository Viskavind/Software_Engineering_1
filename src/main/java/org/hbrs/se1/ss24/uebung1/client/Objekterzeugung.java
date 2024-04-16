package org.hbrs.se1.ss24.uebung1.client;

import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;

public class Objekterzeugung {
    public static String Objekt(int number) {
        RomanNumberTransformer romNum = new RomanNumberTransformer();
        return romNum.transformNumber(number);
    }
}
