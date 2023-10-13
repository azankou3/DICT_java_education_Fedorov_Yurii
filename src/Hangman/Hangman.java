package Hangman;
import java.util.Scanner;
import java.util.Random;
public class Hangman {
    public static void main(String[] args){
        String[] WordData = {"java", "python", "javascript", "kotlin"};
        Random random = new Random();
        int randomIndex = random.nextInt(WordData.length);
        String randomWord = WordData[randomIndex];


        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        choice = choice.toLowerCase();
        if (choice.equals(randomWord)){
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
