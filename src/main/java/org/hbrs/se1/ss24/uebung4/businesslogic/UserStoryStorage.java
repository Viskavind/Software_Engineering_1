package org.hbrs.se1.ss24.uebung4.businesslogic;

import java.io.*;
import java.util.ArrayList;

public class UserStoryStorage implements Serializable{

    private final ArrayList<UserStory> userStories = new ArrayList<>();


    public UserStoryStorage(){

    }


    public int size(){
        int size = 0;
        for(UserStory userStory : userStories){
            size++;
        }
        return size;
    }

    public String addUserStory(UserStory userStory) {
        for (UserStory existingUserStory : userStories) {
            if (existingUserStory.getId() == userStory.getId()) {
                return "Die UserStory mit der Id:" + userStory.getId() +  " existiert bereits";
            }
        }
        userStories.add(userStory);
        return "User Story wurde hinzugefügt";
    }

    public UserStory getUserStory(int id){
        for (UserStory userStory : userStories) {
            if(userStory.getId() == id) {
                return userStory;
            }
        }
        System.out.println("UserStory wurde nicht gefunden");
        return null;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(UserStory userStory : userStories){
            str.append(userStory.toString()).append("\n");
        }
        return str.toString();
    }

    public void saveUserStories() throws UserStoryStorageException {
        try {
            FileOutputStream fos = new FileOutputStream("userStories.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (UserStory userStory : userStories) {
                oos.writeObject(userStory);
            }

            fos.close();
            oos.close();
            userStories.clear();
        } catch (IOException e) {
            throw new UserStoryStorageException("Fehler beim Speichern der UserStories",e);
        }
    }

    public void loadUserStories() throws UserStoryStorageException {
        try {
            FileInputStream fis = new FileInputStream("userStories.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    UserStory userStory = (UserStory) ois.readObject();
                    userStories.add(userStory);
                } catch (EOFException e) {
                    break;
                }
            }

            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new UserStoryStorageException("Fehler beim Laden der UserStories",e);
        }
    }
}
