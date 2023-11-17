package Hangman;
import java.util.Scanner;
public class HangMenu {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        while (playing)
            if (playing){
                System.out.println("Type 'play' to play the game, 'exit' to quit: ");
                String input = scanner.next();
                if (input.equals("play")){
                    Hangman.main(new String[0]);
                }else if (input.equals("exit")) {
                    System.out.println("Goodbye");
                    playing = false;
                }
            }
    }
}
