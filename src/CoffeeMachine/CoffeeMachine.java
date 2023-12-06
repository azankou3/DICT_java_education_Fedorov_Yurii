package CoffeeMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import CoffeeMachine.Coffee;

public class CoffeeMachine {

    static class CoffeeMachineResources extends Coffee.CoffeeType {
        public CoffeeMachineResources(int Water, int Milk, int CoffeeBeans){
            super(Water, Milk, CoffeeBeans);
        }
    }
    static class coffeetype1 extends Coffee.CoffeeType {
        public coffeetype1(int Water, int Milk, int CoffeeBeans) {
            super(Water, Milk, CoffeeBeans);
        }
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has: ");
        int Water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int Milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int CoffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = scanner.nextInt();

        CoffeeMachineResources Machine = new CoffeeMachineResources(Water, Milk, CoffeeBeans);

        int machineWater = Machine.getWater();
        int machineMilk = Machine.getMilk();
        int machineCoffeeBeans = Machine.getCoffeeBeans();



        coffeetype1 coffee1 = new coffeetype1(150, 50, 15);

        int FOCWater = coffee1.getWater(); // FOC - For one cup
        int FOCMilk = coffee1.getMilk();
        int FOCCoffeeBeans = coffee1.getCoffeeBeans();

        HashMap<String, Integer> Maxcups = new HashMap<>();
        Maxcups.put("Water", (machineWater / FOCWater));
        Maxcups.put("Milk", (machineMilk / FOCMilk));
        Maxcups.put("CoffeeBeans", (machineCoffeeBeans / FOCCoffeeBeans));

        int xw = Maxcups.get("Water");
        int xm = Maxcups.get("Milk");
        int xc = Maxcups.get("CoffeeBeans");
        int x = xw;
        int[] min= {xw,xm,xc};
        for (int i = 0; i < min.length ;i++){
            if (x > min[i]){
                x=min[i];
            }
        }
//        System.out.println("Min cups is = " + x);
//        System.out.println("MaxCUPS Amount " + Maxcups);

        HashMap<String, Integer> ForAllCups = new HashMap<>();

        ForAllCups.put("Water", (FOCWater * cups));
        ForAllCups.put("Milk", (FOCMilk * cups));
        ForAllCups.put("CoffeeBeans", (FOCCoffeeBeans * cups));

//        System.out.println(ForAllCups);

        int FACWater = ForAllCups.get("Water");
        int FACMilk = ForAllCups.get("Milk");
        int FACCoffeeBeans = ForAllCups.get("CoffeeBeans");

        boolean BooleanWater = FACWater > machineWater;
        boolean BooleanMilk = FACMilk > machineMilk;
        boolean BooleanCoffeeBeans = FACCoffeeBeans > machineCoffeeBeans;
        boolean admin = false;
        if (admin) {
            if (BooleanWater) {
                System.out.println("Need refill water");
                System.out.println("Need " + Math.abs(machineWater - FACWater) + " ml more");
            }
            if (BooleanMilk) {
                System.out.println("Need refill milk");
                System.out.println("Need " + Math.abs(machineMilk - FACMilk) + " ml more");
            }
            if (BooleanCoffeeBeans) {
                System.out.println("Need refill Coffee beans");
                System.out.println("Need " + Math.abs(machineCoffeeBeans - FACCoffeeBeans) + " g more");
            }
        }
        if (!BooleanCoffeeBeans && !BooleanMilk && !BooleanWater){
            if (cups < x){
                System.out.println("Yes i can make that amount of coffee and even (" + (x - cups)+") more");
            }
            if (cups == x) {
                System.out.println("Yes i can make that amount of coffee");
            }
        }
        if (BooleanCoffeeBeans && BooleanMilk && BooleanWater){
            System.out.println("No, i can make only " + x +" cups of coffee");
        }
    }
}
