package org.hbrs.se1.ss24.uebung1.test;

import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRomanNumberTransformer {

    RomanNumberTransformer test1 = new RomanNumberTransformer();

    @Test
    void TestRomanNumbers() {

        assertEquals("MMM", test1.transformNumber(3000));
        assertEquals("I", test1.transformNumber(1));
        assertEquals("IV", test1.transformNumber(4));


    }

    @Test
    void TestExceptions() {

        assertThrows(IllegalArgumentException.class, ()-> test1.transformNumber(3011));
        assertThrows(IllegalArgumentException.class, ()-> test1.transformNumber(0));
        assertThrows(IllegalArgumentException.class, ()-> test1.transformNumber(-6546));
    }
}

