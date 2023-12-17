package CoffeeMachine;

import java.util.HashMap;
import java.util.Scanner;
import CoffeeMachine.Coffee;

public class CoffeeMachine {

    static class CoffeeMachineResources extends Coffee.CoffeeType {
        public CoffeeMachineResources(int Water, int Milk, int CoffeeBeans, int Money, int Cups){
            super(Water, Milk, CoffeeBeans, Money, Cups);
        }
    }
    static class coffeetype1 extends Coffee.CoffeeType {
        public coffeetype1(int Water, int Milk, int CoffeeBeans, int Price, int Cups) {
            super(Water, Milk, CoffeeBeans, Price, Cups);
        }
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean work = true;

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int money = 550;
        int cupsInMachine = 9;

        CoffeeMachineResources Machine = new CoffeeMachineResources(water, milk, coffeeBeans, money, cupsInMachine);

        while (work) {
            System.out.println("Write action: (buy, fill, take, remaining, exit) ");
            System.out.print("> ");
            String action = scanner.nextLine();

            switch (action) {
                case "take":
                    System.out.println("I gave you " + Machine.getPrice() + " ");
                    Machine.setPrice(0);
                    break;
                case "buy":
                    // Логіка покупки кави тут
                    coffeetype1 Espresso = new coffeetype1(250, 0, 16,4, 1);
                    coffeetype1 Latte = new coffeetype1(350, 75, 20, 7, 1);
                    coffeetype1 Cappuccino = new coffeetype1(200, 100, 12, 6, 1);

                    coffeetype1[] CoffeeArray ={Espresso, Latte, Cappuccino};
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, " +
                            "3 - cappuccino, back - to main menu :");
                    System.out.print(">");
                    String input = scanner.nextLine();
                    if (input.matches("back")){
                        break;
                    }

                    int chooseCoffee = 1;

                    if (input.matches(".*\\d.*")){
                        try {
                            chooseCoffee = Integer.parseInt(input);
                            if (chooseCoffee < 1 || chooseCoffee >3){
                                System.out.println("Please enter a number from 1 to 3");
                                break;
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Pleas enter valid number");
                        }

                    }

                    int CoffeeIndex = chooseCoffee -1;

                    System.out.println("Write how many cups of coffee you will need: ");
                    int cups = scanner.nextInt();
                    scanner.nextLine();
                    if (cups > Machine.getCups()){
                        System.out.println("not enough cups");
                        break;
                    }

                    int FOCWater = CoffeeArray[CoffeeIndex].getWater(); // FOC - For one cup
                    int FOCMilk = CoffeeArray[CoffeeIndex].getMilk();
                    int FOCCoffeeBeans = CoffeeArray[CoffeeIndex].getCoffeeBeans();
                    int FOCPrice = CoffeeArray[CoffeeIndex].getPrice();


                    HashMap<String, Integer> Maxcups = new HashMap<>();
                    if (FOCMilk == 0 ){
                        FOCMilk = 1;
                    }
                    Maxcups.put("Water", (Machine.getWater() / FOCWater));
                    Maxcups.put("Milk", (Machine.getMilk() / FOCMilk));
                    Maxcups.put("CoffeeBeans", (Machine.getCoffeeBeans() / FOCCoffeeBeans));

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
                    HashMap<String, Integer> ForAllCups = new HashMap<>();

                    ForAllCups.put("Water", (FOCWater * cups));
                    ForAllCups.put("Milk", (FOCMilk * cups));
                    ForAllCups.put("CoffeeBeans", (FOCCoffeeBeans * cups));

                    int FACWater = ForAllCups.get("Water");
                    int FACMilk = ForAllCups.get("Milk");
                    int FACCoffeeBeans = ForAllCups.get("CoffeeBeans");
                    int FACPrice = FOCPrice * cups;

                    // Перевірка наявності ресурсів перед виконанням операції
                    int errors = 0;
                    if (Machine.getCups() <= 0) {
                        System.out.println("Not enough cups");
                        errors = errors + 1;
                    }
                    if (Machine.getWater() < FACWater){
                        System.out.println("Not enough water");
                        errors = errors + 1;
                    }
                    if (Machine.getMilk() < FACMilk){
                        System.out.println("Not enough milk");
                        errors = errors + 1;
                    }
                    if (Machine.getCoffeeBeans() < FACCoffeeBeans){
                        System.out.println("Not enough coffee beans");
                        errors = errors + 1;
                    }

                    if (errors == 0){
                        boolean BooleanWater = FACWater > Machine.getWater();
                        boolean BooleanMilk = FACMilk > Machine.getMilk();
                        boolean BooleanCoffeeBeans = FACCoffeeBeans > Machine.getCoffeeBeans();

                        if (!BooleanCoffeeBeans && !BooleanMilk && !BooleanWater){
                            if (cups < x){
                                System.out.println("Yes i can make that amount of coffee and even (" + (x - cups)+") more");
                                Machine.setPrice(Machine.getPrice() + FACPrice);
                                Machine.setWater(Machine.getWater()- FACWater);
                                Machine.setMilk(Machine.getMilk() - FACMilk);
                                Machine.setCoffeeBeans(Machine.getCoffeeBeans() - FACCoffeeBeans);
                                Machine.setCups(Machine.getCups() - cups);

                            }
                            if (cups == x) {
                                System.out.println("Yes i can make that amount of coffee");
                                Machine.setPrice(Machine.getPrice() + FACPrice);
                                Machine.setWater(Machine.getWater()- FACWater);
                                Machine.setMilk(Machine.getMilk() - FACMilk);
                                Machine.setCoffeeBeans(Machine.getCoffeeBeans() - FACCoffeeBeans);
                                Machine.setCups(Machine.getCups() - cups);

                            }
                        }
                        if (BooleanCoffeeBeans || BooleanMilk || BooleanWater){
                            System.out.println("No, i can make only " + x +" cups of coffee");
                        }
                    }else if (errors > 0){
                        System.out.println("No, i can make only " + x +" cups of coffee");
                    }

                    // Інші умови перевірки ресурсів перед покупкою

                    // Якщо все ОК, виконати покупку
                    // ваша логіка покупки кави тут

                    break;
                case "fill":
                    System.out.println("Write how many ml of water the coffee machine has: ");
                    int Water = scanner.nextInt();
                    System.out.println("Write how many ml of milk the coffee machine has: ");
                    int Milk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans the coffee machine has: ");
                    int CoffeeBeans = scanner.nextInt();
                    System.out.println("Write how many cups in the machine: ");
                    int machineCups = scanner.nextInt();

                    Machine.setWater(Machine.getWater() + Water);
                    Machine.setMilk(Machine.getMilk() + Milk);
                    Machine.setCoffeeBeans(Machine.getCoffeeBeans() + CoffeeBeans);
                    Machine.setCups(Machine.getCups() + machineCups);

                    System.out.println("The coffee machine has:");
                    System.out.println(Machine.getWater() + " ml of water");
                    System.out.println(Machine.getMilk() + " ml of milk");
                    System.out.println(Machine.getCoffeeBeans() + " g of coffee beans");
                    System.out.println(Machine.getCups() + " of disposable cups");
                    System.out.println(Machine.getPrice() + " of money");

                    scanner.nextLine();

                    break;
                case "exit":
                    work = false;
                    break;
                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(Machine.getWater() + " ml of water");
                    System.out.println(Machine.getMilk() + " ml of milk");
                    System.out.println(Machine.getCoffeeBeans() + " g of coffee beans");
                    System.out.println(Machine.getCups() + " of disposable cups");
                    System.out.println(Machine.getPrice() + " of money");
                    break;
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
    }
}
