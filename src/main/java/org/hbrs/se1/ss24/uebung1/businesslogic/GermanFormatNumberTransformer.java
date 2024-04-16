package org.hbrs.se1.ss24.uebung1.businesslogic;

import java.text.DecimalFormat;

public class GermanFormatNumberTransformer implements NumberTransformer {

    public GermanFormatNumberTransformer() {

    }

    public String transformNumber(int number) throws java.lang.IllegalArgumentException {
        if (number < 1 || number > 3000) {
            throw new IllegalArgumentException("Zahl nicht im Wertebereich zwischen 1 und 3000");
        }

        DecimalFormat deutsch = new DecimalFormat();
        return deutsch.format(number);
    }


    public String getTransformerType() {
        return "Transformer für deutsche Zahlenformatierungen";
    }
}
