package CreditCalculator;

import javax.sql.rowset.serial.SerialStruct;
import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the loan principal:");
        System.out.print("> ");
        int principal = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What do you want to calculate?");
        System.out.println("type ( m ) - for number of monthly payments");
        System.out.println("type ( p ) - for the monthly payment:");
        System.out.print("> ");
        String type = scanner.nextLine();

        switch (type){
            case "m":
                System.out.println("M");
                System.out.println("Enter the monthly payment: ");
                int monthlyPayment = scanner.nextInt();
                scanner.nextLine();
                float takeMonths = principal / monthlyPayment;
                System.out.println("It will take "+ takeMonths +" month to repay the loan");
                break;
            case "p":
                System.out.println("P");
                System.out.println("Enter the number of months:");
                int months = scanner.nextInt();
                scanner.nextLine();
                float payment = principal / months;
                int Round_Payment = (int) Math.round(payment);
                int periods = months;
                int lastPeriods = periods -1;
                int lastPayment = principal - lastPeriods * Round_Payment;
                int lastPayment2 = principal - lastPeriods * lastPayment;
                if (lastPayment != lastPayment2){
                    System.out.println("Your monthly payment = "+ lastPayment +" and the last payment = "+ lastPayment2);
                }else {
                    System.out.println("Your monthly payment = "+ principal / months);
                }

                break;
            default:
                System.out.println("Please use correct type");
                break;
        }
    }
}
