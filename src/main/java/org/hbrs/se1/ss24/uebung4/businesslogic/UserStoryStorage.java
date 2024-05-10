package org.hbrs.se1.ss24.uebung4.businesslogic;

import java.io.*;
import java.util.ArrayList;

public class UserStoryStorage implements Serializable{

    private final ArrayList<UserStory> userStories = new ArrayList<>();

    public UserStoryStorage(){

    }


    public void addUserStory(UserStory userStory) throws UserStoryStorageException{
        for (UserStory existingUserStory : userStories) {
            if (existingUserStory.getId().equals(userStory.getId())) {
                throw new UserStoryStorageException("Das UserStory-Objekt mit der ID " + userStory.getId() + " ist bereits vorhanden");
            }
        }
        userStories.add(userStory);
    }

    public UserStory getUserStory(String id) throws UserStoryException {
        for (UserStory userStory : userStories) {
            if(userStory.getId().equals(id)) {
                return userStory;
            }
            else{
                throw new UserStoryException("UserStory existiert nicht");
            }
        }
        return null;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(UserStory userStory : userStories){
            str.append("\n").append(userStory.toString());
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
