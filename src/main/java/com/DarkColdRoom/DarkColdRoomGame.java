package com.DarkColdRoom;

import java.util.Scanner;

public class DarkColdRoomGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        System.out.println("You wake up alone in a dark room. What do you do?");
        System.out.println("a) Scream\nb) Look for a light");

        while (!gameOver) {
            System.out.print("Choose your action (a/b): ");
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "a":
                    gameOver = scream(scanner);
                    break;
                case "b":
                    gameOver = searchForLight(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static boolean scream(Scanner scanner) {
        System.out.println("You scream, but no one responds. The sound of footsteps echoes. \nThe door opens, and your kidnapper enters and turns on the light.");
        System.out.println("He approaches, smiles, and says - You're safe here.");
        return interactWithKidnapper(scanner);
    }

    public static boolean searchForLight(Scanner scanner) {
        System.out.println("You find a lighter and light a flame. \nYou see a locked door. \nNext to you, there is a drawer with 3 drawers.");
        return searchForKey(scanner);
    }

    public static boolean interactWithKidnapper(Scanner scanner) {
        System.out.println("a) Talk\nb) Attack\nc) Escape");

        String choice = scanner.nextLine().toLowerCase();

        if ("a".equals(choice)) return tryToTalk();
        if ("b".equals(choice)) return tryToAttack();
        if ("c".equals(choice)) return tryToEscape();

        return true;
    }

    public static boolean tryToEscape() {
        System.out.println("You run to the door, but the kidnapper grabs you and throws you back.");
        return gameOver();
    }

    public static boolean tryToTalk() {
        System.out.println("You try to convince the kidnapper to let you go, but he laughs.");
        return gameOver();
    }

    public static boolean tryToAttack() {
        System.out.println("You try to attack, but the kidnapper disarms you.");
        return gameOver();
    }

    public static boolean searchForKey(Scanner scanner) {
        System.out.println("You find a key in the middle drawer. You try to open the door.");
        System.out.println("The door opens slowly.");
        return continueEscaping(scanner);
    }

    public static boolean continueEscaping(Scanner scanner) {
        System.out.println("You are in a dark corridor and hear footsteps behind you.");
        System.out.println("a) Go back\nb) Look for a hiding spot\nc) Stop and face it");

        String choice = scanner.nextLine().toLowerCase();

        if ("a".equals(choice)) {
            System.out.println("You go back to where you should never have left.");
            return gameOver();
        } else if ("b".equals(choice)) {
            System.out.println("You hide, but the kidnapper finds you.");
            return gameOver();
        } else if ("c".equals(choice)) {
            System.out.println("You try to face it, but the kidnapper is stronger.");
            return gameOver();
        }

        return gameOver();
    }

    public static boolean gameOver() {
        return darkQuiz();
    }

    public static boolean darkQuiz() {
        Scanner scanner = new Scanner(System.in);
        if (!askQuiz(scanner, "You will never see the light again. You will?")) {
            return true;
        }

        if (!askQuiz(scanner, "You are dreaming that you're in a long line, there are people in front of you but no one behind you. Do you feel the urge to bite your nails?")) {
            return true;
        }

        if (!askQuiz(scanner, "You're descending stairs, step by step, the stairs are short but you are going down slowly. Do you look down?")) {
            return true;
        }

        System.out.println("You're sitting in front of your computer, carefully thinking about what to answer. You feel a warm breath on the back of your neck. Someone is watching you. Do you look back?");
        return true;
    }

    public static boolean askQuiz(Scanner scanner, String question) {
        System.out.println(question);
        String answer;
        boolean validAnswer;
        do {
            System.out.print("Answer (yes/no): ");
            answer = scanner.nextLine().toLowerCase();
            validAnswer = answer.equals("yes") || answer.equals("no");
            if (!validAnswer) {
                System.out.println("Invalid answer. Please try again.");
            }
        } while (!validAnswer);
        return true;
    }
}
