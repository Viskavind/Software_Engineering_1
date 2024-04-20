package org.hbrs.se1.ss24.uebung2.businesslogic;

public abstract class PersonCardAbstract implements PersonCard{

    private final String firstName;
    private final String lastName;
    private final int id;

    protected PersonCardAbstract(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = this.hashCode();
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
        return "PersonCard [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
    }
}
