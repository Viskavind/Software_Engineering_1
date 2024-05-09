package org.hbrs.se1.ss24.uebung4.businesslogic;

import java.io.*;
import java.util.ArrayList;

public class UserStoryStorage {

    private ArrayList<UserStory> userStories = new ArrayList<UserStory>();

    public UserStoryStorage(ArrayList<UserStory> userStories) {
        this.userStories = userStories;
    }

    public void addUserStory(UserStory userStory) {
        userStories.add(userStory);
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
