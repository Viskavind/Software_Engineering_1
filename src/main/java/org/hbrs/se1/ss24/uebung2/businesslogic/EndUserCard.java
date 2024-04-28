package org.hbrs.se1.ss24.uebung2.businesslogic;

public class EndUserCard extends PersonCardAbstract{

    private final boolean isHungry;

    public EndUserCard(String firstName, String lastName, int id, boolean isHungry) {
        super(firstName, lastName, id);
        this.isHungry = isHungry;
    }

    @Override
    public String toString() {
        return super.toString() + ", isHungry=[" + isHungry + "]";
    }


}
