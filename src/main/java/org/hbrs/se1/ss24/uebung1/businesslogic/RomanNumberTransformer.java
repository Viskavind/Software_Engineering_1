package org.hbrs.se1.ss24.uebung1.businesslogic;

public class RomanNumberTransformer implements NumberTransformer {

    public RomanNumberTransformer() {

    }

    public String transformNumber(int number) throws java.lang.IllegalArgumentException {
        if (number < 1 || number > 3000) {
            throw new IllegalArgumentException("Zahl nicht im Wertebereich zwischen 1 und 3000");
        }

        //if (!(Integer.class.isInstance(number))){
          //  throw new IllegalArgumentException("Zahl ist kein Integer");
        //}
        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL",
                "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] romanValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder romanNumeral = new StringBuilder();
        for (int i = romanValues.length - 1; i >= 0; i--) {
            while (number >= romanValues[i]) {
                romanNumeral.append(romanSymbols[i]);
                number -= romanValues[i];
            }
        }
        return romanNumeral.toString();
    }

    public String getTransformerType() {
        return "Transformer für römische Zahlen";
    }

}
