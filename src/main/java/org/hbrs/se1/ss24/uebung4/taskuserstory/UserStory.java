package org.hbrs.se1.ss24.uebung4.taskuserstory;

import java.util.ArrayList;


public class UserStory extends AbstractTaskUserStory {


    private final String prio;
    private final ArrayList<Task> tasks = new ArrayList<>();

    public UserStory (int id, String description, String prio) {
        super(id, description);
        this.prio = prio;

    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "UserStory [id=" + super.getId() + ", description=" + super.getDescription() + ", prio=" + prio + ", tasks=" + tasks + "]";
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

    
