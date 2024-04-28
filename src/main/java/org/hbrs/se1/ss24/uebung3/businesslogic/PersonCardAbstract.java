package org.hbrs.se1.ss24.uebung3.businesslogic;

import java.io.Serializable;

public abstract class PersonCardAbstract implements PersonCard, Serializable {

    private final String firstName;
    private final String lastName;
    private final int id;

    protected PersonCardAbstract(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "ID= [" + id  + "], Vorname= [" + firstName + "], Nachname= ["+ lastName + "]";
    }
}
