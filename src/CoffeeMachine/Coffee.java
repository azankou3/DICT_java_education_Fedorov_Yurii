package CoffeeMachine;
import java.util.HashMap;
import java.util.Scanner;
public class Coffee {
    abstract static class CoffeeType {
        private int Water;
        private int Milk;
        private int CoffeeBeans;
        private int Price;
        private int Cups;

        public CoffeeType(int Water, int Milk, int CoffeeBeans, int Price, int Cups) {
            this.Water = Water;
            this.Milk = Milk;
            this.CoffeeBeans = CoffeeBeans;
            this.Price = Price;
            this.Cups = Cups;
        }

        public int getWater() {
            return this.Water;
        }

        public int getMilk() {
            return this.Milk;
        }

        public int getCoffeeBeans() {
            return this.CoffeeBeans;
        }

        public void setWater(int water) {
            this.Water = water;
        }

        public void setMilk(int milk) {
            this.Milk = milk;
        }

        public void setCoffeeBeans(int coffeeBeans) {
            this.CoffeeBeans = coffeeBeans;
        }
        public int getPrice(){return this.Price;}
        public  void setPrice(int price){this.Price = price;}
        public int getCups(){return this.Cups;}
        public void setCups(int cups){this.Cups=cups;}
    }

    static class coffeetype1 extends CoffeeType {
        public coffeetype1(int Water, int Milk, int CoffeeBeans, int Price, int Cups) {
            super(Water, Milk, CoffeeBeans, Price, Cups);
        }
    }

    static class CoffeeMachineResources extends CoffeeType {
        public CoffeeMachineResources(int Water, int Milk, int CoffeeBeans, int Money, int Cups) {
            super(Water, Milk, CoffeeBeans, Money, Cups);
        }
    }
}

