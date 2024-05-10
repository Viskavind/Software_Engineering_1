package org.hbrs.se1.ss24.uebung4.businesslogic;

import java.io.Serializable;
import java.util.ArrayList;


public class UserStory implements Serializable {

    private final String id;
    private final String description;
    private final String prio;
    private final ArrayList<Task> tasks = new ArrayList<>();

    public UserStory (int id, String description, String prio) {
        this.description = description;
        this.prio = prio;
        this.id = "U"+id;
    }

    public String getId() {return id;}

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "UserStory [id=" + id + ", description=" + description + ", prio=" + prio + ", tasks=" + tasks + "]";
    }

    public void addTask(Task task) throws UserStoryException {
        for (Task existingTask : tasks) {
            if (existingTask.getId().equals(task.getId())) {
                throw new UserStoryException("Das CardBox-Objekt mit der ID " + task.getId() + " ist bereits vorhanden");
            }
        }

        tasks.add(task);
    }


}

    
