package CoffeeMachine;
import java.util.HashMap;
import java.util.Scanner;
public class Coffee {
    abstract static class CoffeeType {
        private int Water;
        private int Milk;
        private int CoffeeBeans;

        public CoffeeType(int Water, int Milk, int CoffeeBeans) {
            this.Water = Water;
            this.Milk = Milk;
            this.CoffeeBeans = CoffeeBeans;
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
    }

    static class coffeetype1 extends CoffeeType {
        public coffeetype1(int Water, int Milk, int CoffeeBeans) {
            super(Water, Milk, CoffeeBeans);
        }
    }

    static class CoffeeMachineResources extends CoffeeType {
        public CoffeeMachineResources(int Water, int Milk, int CoffeeBeans) {
            super(Water, Milk, CoffeeBeans);
        }
    }
}

