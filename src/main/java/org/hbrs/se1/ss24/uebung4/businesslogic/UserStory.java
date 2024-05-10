package org.hbrs.se1.ss24.uebung4.businesslogic;

import java.io.Serializable;
import java.util.ArrayList;


public class UserStory implements Serializable {

    private final int id;
    private final String description;
    private final String prio;
    private final ArrayList<Task> tasks = new ArrayList<>();

    public UserStory (int id, String description, String prio) {
        this.description = description;
        this.prio = prio;
        this.id = id;
    }

    public int getId() {return id;}

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "UserStory [id=" + id + ", description=" + description + ", prio=" + prio + ", tasks=" + tasks + "]";
    }

    public String addTask(Task task) {
        for (Task existingTask : tasks) {
            if (existingTask.getId() == task.getId()) {
                return "Der Task mit der ID " + task.getId() + " ist bereits vorhanden";
            }
        }
        tasks.add(task);
        return "Der Task wurde der UserStory hinzugefügt";
    }


}

    
