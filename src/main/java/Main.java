import entities.Interest;
import entities.Loan;
import services.LoanCalculationService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoanCalculationService loanCalculationService = new LoanCalculationService();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the amount you wish for your house loan: ");
        double loanAmount = input.nextDouble();
        System.out.println("Please enter the payback time in years: ");
        int years = input.nextInt();
        Loan loan = new Loan(loanAmount, years, new Interest());

        loanCalculationService.calculateMonthlyPaymentForPaymentSchemeOnLoan(loan);
        loanCalculationService.calculatePaymentPlan(loan);

        ArrayList<Integer> sortedPaymentPlan = loanCalculationService.mapToSortedArrayList(loan.getPaymentPlan());

        System.out.println("This is your paymentplan based on monthly payment");
        for (Integer x : sortedPaymentPlan) {
            System.out.println("Month: " + x + " " + "Amount: " + String.format("%.2f",loan.getPaymentPlan().get(x) ));
        }

    }
}
