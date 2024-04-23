package org.hbrs.se1.ss24.uebung2.businesslogic;

public class DeveloperCard extends PersonCardAbstract{

    private final boolean hasEnoughCoffee;

    public DeveloperCard(String firstName, String lastName, boolean hasEnoughCoffee) {
        super(firstName, lastName);
        this.hasEnoughCoffee = hasEnoughCoffee;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasEnoughCoffee=[" + hasEnoughCoffee + "]";
    }
}
