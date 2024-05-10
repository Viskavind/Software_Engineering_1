package org.hbrs.se1.ss24.uebung4.taskuserstory;

import java.io.Serializable;

public abstract class AbstractTaskUserStory implements Serializable {

    private final int id;
    private final String description;

    public AbstractTaskUserStory(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
