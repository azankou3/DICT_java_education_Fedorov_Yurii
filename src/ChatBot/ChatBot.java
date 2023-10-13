package ChatBot;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args){
        System.out.println("Hello! my name is T");
        System.out.println("I was created in 2023");
        System.out.println("Please, remind me your name");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name:");
        String name = input.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }
}
