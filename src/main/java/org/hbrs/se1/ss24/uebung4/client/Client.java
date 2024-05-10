package org.hbrs.se1.ss24.uebung4.client;

import org.hbrs.se1.ss24.uebung4.businesslogic.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UserStoryException {

        UserStoryStorage storyStorage = new UserStoryStorage();
        TaskStorage taskStorage = new TaskStorage();
        UserStory story;
        Task task;
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

                System.out.println(storyStorage.addUserStory(story));

                }

            if (command.equals("task")) {
                taskid = scanner.nextInt();
                description = scanner.nextLine();
                task = new Task(description, taskid);
                System.out.println(taskStorage.addTask(task));

            }
            if (command.equals("assign")) {

                int adduserstoryid = scanner.nextInt();
                int addtaskid = scanner.nextInt();
                Task t = taskStorage.getTasks(addtaskid);
                if (t != null) {
                    System.out.println(storyStorage.getUserStory(adduserstoryid).addTask(t));
                }

            }

            if (command.equals("stories")) {
                System.out.println(storyStorage);
            }

            if (command.equals("tasks")) {
                System.out.println(taskStorage);
            }

            if (command.equals("load")) {
                try {
                    storyStorage.loadUserStories();
                //    taskStorage.loadTasks();
                } catch (UserStoryStorageException e) {
                    throw new RuntimeException(e);
                }
            }
            if (command.equals("save")) {
                try {
                    storyStorage.saveUserStories();
                //    taskStorage.saveTasks();
                } catch (UserStoryStorageException e) {
                    throw new RuntimeException(e);

                }
            }


        }

        scanner.close();

    }
}
