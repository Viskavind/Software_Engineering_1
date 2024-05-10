package org.hbrs.se1.ss24.uebung4.storage;

import org.hbrs.se1.ss24.uebung4.taskuserstory.AbstractTaskUserStory;

import java.io.*;
import java.util.ArrayList;

public abstract class AbstractStorage<T extends AbstractTaskUserStory> implements Serializable {

    private final ArrayList<T> list = new ArrayList<>();

    public int size(){
        return list.size();
    }

    public String add(T item) {
        for (T existingItem : list) {
            if (existingItem.getId() == item.getId()) {
                return "The item with the Id:" + item.getId() +  " already exists";
            }
        }
        list.add(item);
        return "Item added";
    }

    public T get(int id){
        for (T item : list) {
            if(item.getId() == id) {
                return item;
            }
        }
        System.out.println("Item not found");
        return null;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(T item : list){
            str.append(item.toString()).append("\n");
        }
        return str.toString();
    }

    public void save(String filename) throws UserStoryStorageException {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (T item : list) {
                oos.writeObject(item);
            }

            fos.close();
            oos.close();
            list.clear();
        } catch (IOException e) {
            throw new UserStoryStorageException("Error saving the items",e);
        }
    }

    public void load(String filename) throws UserStoryStorageException {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    T item = (T) ois.readObject();
                    list.add(item);
                } catch (EOFException e) {
                    break;
                }
            }

            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new UserStoryStorageException("Error loading the items",e);
        }
    }
}
