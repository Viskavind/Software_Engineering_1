package org.hbrs.se1.ss24.uebung4.taskuserstory;

public class Task extends AbstractTaskUserStory {


    public Task (String description, int id){
        super(id, description);
    }

     @Override
    public String toString() {
        return "Task [id=" + super.getId() + ", description=" + super.getDescription() + "]";
    }
}
