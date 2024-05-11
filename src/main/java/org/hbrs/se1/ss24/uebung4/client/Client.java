package org.hbrs.se1.ss24.uebung4.client;

import org.hbrs.se1.ss24.uebung4.taskuserstory.*;
import org.hbrs.se1.ss24.uebung4.storage.TaskStorage;
import org.hbrs.se1.ss24.uebung4.storage.UserStoryStorage;
import org.hbrs.se1.ss24.uebung4.storage.UserStoryStorageException;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        UserStoryStorage storyStorage = new UserStoryStorage();
        TaskStorage taskStorage = new TaskStorage();
        UserStory story;
        Task task;
        String description;
        int taskid;
        int userid;
        String prio;


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

                System.out.println(storyStorage.add(story));

                }

            if (command.equals("task")) {
                taskid = scanner.nextInt();
                description = scanner.nextLine();
                task = new Task(description, taskid);
                System.out.println(taskStorage.add(task));

            }
            if (command.equals("assign")) {

                int adduserstoryid = scanner.nextInt();
                int addtaskid = scanner.nextInt();
                Task t = taskStorage.get(addtaskid);
                if (t != null) {
                    System.out.println(storyStorage.get(adduserstoryid).addTask(t));
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
                    storyStorage.load("userStories.dat");
                //    taskStorage.loadTasks();
                } catch (UserStoryStorageException e) {
                    throw new RuntimeException(e);
                }
            }
            if (command.equals("save")) {
                try {
                    storyStorage.save("userStories.dat");
                //  taskStorage.saveTasks();
                } catch (UserStoryStorageException e) {
                    throw new RuntimeException(e);

                }
            }


        }

        scanner.close();

    }
}
