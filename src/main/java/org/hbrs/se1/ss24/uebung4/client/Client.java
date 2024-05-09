package org.hbrs.se1.ss24.uebung4.client;

import org.hbrs.se1.ss24.uebung4.businesslogic.Task;
import org.hbrs.se1.ss24.uebung4.businesslogic.UserStory;
import org.hbrs.se1.ss24.uebung4.businesslogic.UserStoryException;
import org.hbrs.se1.ss24.uebung4.businesslogic.UserStoryStorage;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UserStoryException {

        UserStoryStorage storyStorage = new UserStoryStorage();
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
            if (command.equals("exit")){break;}
            if (command.equals("story")) {
                userid = scanner.nextInt();
                String[] tmp = scanner.nextLine().split(",");
                description = tmp[0];
                prio = tmp[1];

                story = new UserStory(userid, description, prio);
                storyStorage.addUserStory(story);
            }
            if (command.equals("task")) {
                taskid = scanner.nextInt();
                description = scanner.nextLine();
                task = new Task(description, taskid);

            }
            if (command.equals("assign")) {
                userid = scanner.nextInt();
                taskid = scanner.nextInt();

            }
            if (command.equals("stories")) {
                System.out.println(storyStorage.toString());
            }
            if (command.equals("tasks")) {}
            if (command.equals("load")) {}
            if (command.equals("save")) {}


        }

        System.out.println(description);
        System.out.println(userid);
        System.out.println(taskid);
        System.out.println(prio);

        scanner.close();

    }
}
