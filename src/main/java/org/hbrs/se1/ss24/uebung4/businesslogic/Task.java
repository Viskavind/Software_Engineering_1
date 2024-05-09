package org.hbrs.se1.ss24.uebung4.businesslogic;

import java.io.Serializable;

public class Task implements Serializable {

    private final String id;
    private final String description;

    public Task (String description, int id){
        this.description = description;
        this.id = "T"+id;
    }

    public String getId() {
        return id;
    }


     @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + "]";
    }
}
