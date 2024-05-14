package org.hbrs.se1.ss24.uebung4.taskuserstory;

import java.util.Objects;

public class Task extends AbstractTaskUserStory {


    public Task (String description, int id){
        super(id, description);
    }

     @Override
    public String toString() {
        return "Task [id=" + super.getId() + ", description=" + super.getDescription() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Task task = (Task) obj;
        return this.getId() == task.getId() &&
                Objects.equals(this.getDescription(), task.getDescription());
    }
}
