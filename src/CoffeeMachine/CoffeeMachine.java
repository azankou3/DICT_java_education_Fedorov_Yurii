package CoffeeMachine;

import java.util.HashMap;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print(">");
        int  cupsInput = scanner.nextInt();

        HashMap<String, Integer> ForOneCup = new HashMap<>();
        ForOneCup.put("Water", 200);
        ForOneCup.put("Milk", 50);
        ForOneCup.put("CoffeeBeans", 15);

        int NeedWater = ForOneCup.get("Water") * cupsInput;
        int NeedMilk = ForOneCup.get("Milk") * cupsInput;
        int NeedCoffeeBeans = ForOneCup.get("CoffeeBeans") * cupsInput;

        System.out.println("For " + cupsInput + " of coffee you will need:");
        System.out.println(NeedWater + " ml of water");
        System.out.println(NeedMilk + " ml of milk");
        System.out.println(NeedCoffeeBeans + " g of coffee beans");

    }
}
