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
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        System.out.println("Reminder by 3");
        int reminder3 = input.nextInt();
        System.out.println("Reminder by 5");
        int reminder5 = input.nextInt();
        System.out.println("Reminder by 7");
        int reminder7 = input.nextInt();
        var age = (reminder3 * 70 + reminder5 * 21 + reminder7 * 15) % 105;
        System.out.println("Your age is " + age + "; that`s a good time to start programming!");
        System.out.println("Now I will prove to you that i can count to any number you want!");
        System.out.println("Enter number:");
        int count = input.nextInt();
        for (int i = 1; i <= count; i++){
            System.out.println(i + " !");
        }

    }
}
