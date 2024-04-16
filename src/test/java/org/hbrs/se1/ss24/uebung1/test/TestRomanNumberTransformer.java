package org.hbrs.se1.ss24.uebung1.test;

import org.hbrs.se1.ss24.uebung1.businesslogic.GermanFormatNumberTransformer;
import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;
import org.hbrs.se1.ss24.uebung1.client.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRomanNumberTransformer {

    RomanNumberTransformer test1 = new RomanNumberTransformer();
    GermanFormatNumberTransformer test2 = new GermanFormatNumberTransformer();

    @Test
    void TestRomanNumbers() {

        assertEquals("3.000", test2.transformNumber(3000));
        assertEquals("MMM",test1.transformNumber(3000));
    }
}
