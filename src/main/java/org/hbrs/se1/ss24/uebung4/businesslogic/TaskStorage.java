package org.hbrs.se1.ss24.uebung4.businesslogic;

import java.io.*;
import java.util.ArrayList;

public class TaskStorage implements Serializable {

    private final ArrayList<Task> tasks = new ArrayList<>();

    public TaskStorage() {}


    public int size(){
        int size = 0;
        for(Task t : tasks){
            size++;
        }
        return size;
    }

    public String addTask(Task task) {
        for (Task t : tasks){
            if (t.getId() == task.getId()){
                return "Task already exists";
            }
        }
        tasks.add(task);
        return "Task added";
    }

    public Task getTasks(int id) {
        for (Task t : tasks){
            if (t.getId() == id){
                return t;
            }

        }
        System.out.println("Task does not exist");
        return null;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Task t : tasks){
            str.append(t.toString()).append("\n");
        }
        return str.toString();
    }

    /*public void saveTasks() throws UserStoryStorageException {
        try {
            FileOutputStream fos = new FileOutputStream("Tasks.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Task t : tasks) {
                oos.writeObject(t);
            }

            fos.close();
            oos.close();
            tasks.clear();
        } catch (IOException e) {
            throw new UserStoryStorageException("Fehler beim Speichern der Tasks",e);
        }
    }

    public void loadTasks() throws UserStoryStorageException {
        try {
            FileInputStream fis = new FileInputStream("Tasks.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Task t = (Task) ois.readObject();
                    tasks.add(t);
                } catch (EOFException e) {
                    break;
                }
            }

            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new UserStoryStorageException("Fehler beim Laden der UserStories",e);
        }
    }*/

}
