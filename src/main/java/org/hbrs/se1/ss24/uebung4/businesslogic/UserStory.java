package org.hbrs.se1.ss24.uebung4.businesslogic;

public class UserStory {

    private int id;
    private String description;
    private String prio;
    private Task[] tasks;

    public UserStory (int id, String description, String prio) {
        this.id = id;
        this.description = description;
        this.prio = prio;
    }


}
