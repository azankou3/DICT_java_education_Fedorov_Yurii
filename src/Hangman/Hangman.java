package Hangman;
import java.util.Scanner;
import java.util.Random;
public class Hangman {
    public static void main(String[] args){
        String[] WordData = {"java", "python", "javascript", "kotlin"};
        Random random = new Random();
        int randomIndex = random.nextInt(WordData.length);
        String randomWord = WordData[randomIndex];
        int hp = 8;
        int hpLeft = hp;
        boolean[] guessed = new boolean[randomWord.length()];
        int lengthOfWord = randomWord.length();
        int lengthOfGuess = 0;
        System.out.println("HANGMAN");
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
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Enter one letter.");
                continue;
            }

            System.out.println();
            char guess = input.charAt(0);
            boolean letterGuessed = false;

            for (int i = 0; i < randomWord.length(); i++) {
                if (randomWord.charAt(i) == guess){
                    if(guessed[i]){
                        System.out.println("No improvements");
                        hpLeft--;
                        lengthOfGuess--;
                    }
                }
                if (randomWord.charAt(i) == guess) {
                    guessed[i] = true;
                    letterGuessed = true;
                    lengthOfGuess++;

                }
            }
            if (letterGuessed) {
                System.out.print("");
            } else {
                System.out.println("That letter doesn`t appear in the word.");
                hpLeft--;
            }
            System.out.println("Attempts left: " + hpLeft);

            System.out.println();
            if (lengthOfGuess == lengthOfWord) {
                System.out.println("You survived");
                break;
            } else if (hpLeft <= 0) {
                System.out.println("You lose!");
                break;
            }
        }
    }
}
