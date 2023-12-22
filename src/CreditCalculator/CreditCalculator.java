package CreditCalculator;

import javax.sql.rowset.serial.SerialStruct;
import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to calculate?");
        System.out.println("type ( m ) - for number of monthly payments");
        System.out.println("type ( p ) - for the monthly payment:");
        System.out.println("type ( n ) - for number of monthly payments:");
        System.out.println("type ( a ) - for annuity monthly payment amount:");
        System.out.print("> ");
        String type = scanner.nextLine();
        int principal;
        float float_principal;
        int periods;
        float loanInterest;
        int monthlyPayment;
        float i;
        double b;
        int years;
        int months;
        int days;
        int N_months;
        switch (type){
            case "m":
                System.out.println("Enter the loan principal:");
                System.out.print("> ");
                principal = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the monthly payment: ");
                monthlyPayment = scanner.nextInt();
                scanner.nextLine();
                float takeMonths = principal / monthlyPayment;
                System.out.println("It will take "+ takeMonths +" month to repay the loan");
                break;
            case "p":
                System.out.println("Enter the loan principal:");
                System.out.print("> ");
                float_principal = scanner.nextFloat();

                scanner.nextLine();
                System.out.println("Enter the number of months:");
                months = scanner.nextInt();
                scanner.nextLine();
                float payment = float_principal / months;
                int Round_Payment = (int) Math.round(payment);
                periods = months;
                int lastPeriods = periods -1;
                float lastPayment = float_principal - lastPeriods * Round_Payment;
                float lastPayment2 = float_principal - lastPeriods * lastPayment;

                if (lastPayment != lastPayment2){
                    System.out.println("Your monthly payment = "+ lastPayment +" and the last payment = "+ lastPayment2);
                }else {
                    System.out.println("Your monthly payment = "+ float_principal / months);
                }

                break;
            case "n":
                System.out.println("Enter the loan principal:");
                System.out.print("> ");
                principal = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the monthly payment:");
                System.out.print("> ");
                monthlyPayment = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the loan interest:");
                System.out.print("> ");
                loanInterest = scanner.nextInt();
                scanner.nextLine();
                i = loanInterest/(12 * 100);
                double n = Math.log(monthlyPayment / (monthlyPayment - i * principal)) / Math.log(1 + i);
                N_months = (int) Math.ceil(n);
                months = N_months%12;
                years = N_months/12;
                if (years > 0 && months >0){
                    System.out.println("It will take " + years + " years and " + months + " months to repay this loan!");
                } else if (years == 0 && months > 0) {
                    System.out.println("It will take "+ months + " months to repay this loan!");
                } else if (years > 0 && months == 0) {
                    System.out.println("It will take "+ years + " years to repay this loan!");
                }
                break;
            case "a":
                System.out.println("Enter the loan principal:");
                System.out.print("> ");
                principal = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the number of periods:");
                System.out.print("> ");
                periods = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the loan interest:");
                System.out.print("> ");
                loanInterest = scanner.nextInt();
                i = loanInterest/(12 * 100);
                scanner.nextLine();
                double xi = Math.pow((1+i),periods);
                double result = Math.ceil((principal * i * xi) / (xi - 1));
                int res = (int) result;

                System.out.println("Your monthly payment is "+ res+"!");
                break;
            default:
                System.out.println("Please use correct type");
                break;
        }
    }
}
