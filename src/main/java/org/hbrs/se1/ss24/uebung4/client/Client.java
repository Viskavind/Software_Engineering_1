package org.hbrs.se1.ss24.uebung4.client;

import org.hbrs.se1.ss24.uebung4.businesslogic.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UserStoryException {

        UserStoryStorage storyStorage = new UserStoryStorage();
        UserStory story;
        Task task;
        ArrayList<Task> taskList = new ArrayList<>();
        String description = "";
        int taskid = 0;
        int userid = 0;
        String prio = "";

        Scanner scanner = new Scanner(System.in);
        while (true){

            System.out.print("Enter command: ");
            String command = scanner.next();

            if (command.equals("exit")) {
                break;
            }

            if (command.equals("story")) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(" ", 2);
                userid = Integer.parseInt(parts[0]);
                String[] descAndPrio = parts[1].split("\"", 3);
                description = descAndPrio[1];
                prio = descAndPrio[2].trim();

                story = new UserStory(userid, description, prio);

                try {
                    storyStorage.addUserStory(story);
                } catch (UserStoryStorageException e) {
                    throw new RuntimeException(e);
                }
            }
            if (command.equals("task")) {
                taskid = scanner.nextInt();
                description = scanner.nextLine();
                task = new Task(description, taskid);
                taskList.add(task);

            }
            if (command.equals("assign")) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(" ", 2);
                String adduserstoryid = parts[0];
                String addtaskid = parts[1];
                for (Task t : taskList) {
                    if (t.getId().equals(addtaskid)) {
                        storyStorage.getUserStory(adduserstoryid).addTask(t);
                    }
                }

                taskList.removeIf(t -> t.getId().equals(addtaskid));

            }

            if (command.equals("stories")) {
                System.out.println(storyStorage);
            }

            if (command.equals("tasks")) {
                for (Task t : taskList) {
                    System.out.println(t.toString());
                }
            }

            if (command.equals("load")) {
                try {
                    storyStorage.loadUserStories();
                } catch (UserStoryStorageException e) {
                    throw new RuntimeException(e);
                }
            }
            if (command.equals("save")) {
                try {
                    storyStorage.saveUserStories();
                } catch (UserStoryStorageException e) {
                    throw new RuntimeException(e);

                }
            }


        }

        System.out.println(description);
        System.out.println(userid);
        System.out.println(taskid);
        System.out.println(prio);

        scanner.close();

    }
}
