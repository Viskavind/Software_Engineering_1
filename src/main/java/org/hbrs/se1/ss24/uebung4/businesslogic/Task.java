package org.hbrs.se1.ss24.uebung4.businesslogic;

import java.io.Serializable;

public class Task implements Serializable {

    private final int id;
    private final String description;

    public Task (String description, int id){
        this.description = description;
        this.id = id;
    }

    public int getId() {
        return id;
    }


     @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + "]";
    }
}
