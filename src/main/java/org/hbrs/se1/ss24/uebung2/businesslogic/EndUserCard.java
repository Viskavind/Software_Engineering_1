package org.hbrs.se1.ss24.uebung2.businesslogic;

public class EndUserCard extends PersonCardAbstract{

    private final boolean isHungry;

    public EndUserCard(String firstName, String lastName, boolean isHungry) {
        super(firstName, lastName);
        this.isHungry = isHungry;
    }

    @Override
    public String toString() {
        return super.toString() + ", isHungry=[" + isHungry + "]";
    }


}
