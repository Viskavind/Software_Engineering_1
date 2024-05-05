package org.hbrs.se1.ss24.uebung4.client;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("> ");

        // Lies den Befehl und die Parameter ein
        String input = scanner.next();

        // Trenne den Befehl und die Parameter
        String[] parts = input.split(" ");
        String command = parts[0];
        String parameter = null;
        if (parts.length > 1) {
            parameter = parts[1];
        }

        // Verarbeite den Befehl
        switch (command) {
            case "befehl":
                if (parameter != null) {
                    System.out.println("Befehl ausgeführt mit Parameter: " + parameter);
                } else {
                    System.out.println("Befehl ausgeführt ohne Parameter");
                }
                break;
            default:
                System.out.println("Unbekannter Befehl: " + command);
        }

        scanner.close();
    }
}
