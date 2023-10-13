package Hangman;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args){
        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if (choice.equals("python")){
            System.out.println("You lost!");
        } else if (choice.equals("java")) {
            System.out.println("You survived!");
        }
    }
}
