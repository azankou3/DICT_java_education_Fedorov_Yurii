package Hangman;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Hangman {
    public static void main(String[] args){
        String[] WordData = {"java", "python", "javascript", "kotlin"};
        Random random = new Random();
        int randomIndex = random.nextInt(WordData.length);
        String randomWord = WordData[randomIndex];
        int hp = 8;
        boolean[] guessed = new boolean[randomWord.length()];
        int lengthOfWord = randomWord.length();
        int lengthOfGuess = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");
        ArrayList allGuessedLetters = new ArrayList<>();
        while(hp > 0) {
            System.out.print("Word: ");
            for (int i = 0; i < randomWord.length(); i++) {
                if (guessed[i]) {
                    System.out.print(randomWord.charAt(i));
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
            System.out.print("Input letter: ");
            String input = scanner.next();
            if (input.length() != 1) {
                System.out.println("You should input a single letter.");
                continue;
            } else if (!input.matches("[a-z]")) {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }
            if (allGuessedLetters.contains(input)){
                System.out.println("Already guessed letter");
                lengthOfGuess = lengthOfGuess - 1;
            } else {
                if (!allGuessedLetters.contains(input)){
                    allGuessedLetters.add(input);
                }
                System.out.print("");
            }
            if (!randomWord.contains(input)){
                hp = hp - 1;
            }else {
                for (int i = 0; i < randomWord.length(); i++) {
                    char ch = randomWord.charAt(i);
                    char inCh = input.charAt(0);
                    boolean answ = ch == inCh;
                    if (answ){
                        guessed[i] = true;
                        lengthOfGuess++;
                    }
                }
            }
            System.out.println("Attempts left: " + hp);
            if (lengthOfGuess == lengthOfWord) {
                System.out.println("You survived");
                break;
            } else if (hp <= 0) {
                System.out.println("You lose!");
                break;
            }

        }
    }
}
