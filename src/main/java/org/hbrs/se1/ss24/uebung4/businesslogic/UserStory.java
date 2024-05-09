package org.hbrs.se1.ss24.uebung4.businesslogic;

import java.util.ArrayList;


public class UserStory {

    private String id;
    private String description;
    private String prio;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public UserStory (int id, String description, String prio) {
        this.description = description;
        this.prio = prio;
        this.id = "U"+id;
    }

    public String getId() {return id;}

    @Override
    public String toString() {
        return "UserStory [id=" + id + ", description=" + description + ", prio=" + prio + ", tasks=" + tasks.toString() + "]";
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

    
