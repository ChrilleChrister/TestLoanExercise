package services;

import entities.Loan;
import entities.PaymentScheme;

import java.util.*;

public class LoanCalculationService {

    //beroende på hur stort systemet ska så kan denna delas upp i en helper istället exempelvis.
    //att generella metoder som convertYearsToMonths kan ligga i en helper.
    //Och bara sådant som berör kalkylering på lånet ska ligga i denna klass.

    //Should also be able to make a method to do some extra down payment.

    public void calculateMonthlyPaymentForPaymentSchemeOnLoan(final Loan loan) {
        double amount = loan.getLoanAmount();
        convertYearsToMonths(loan);
        loan.setPaymentScheme(new PaymentScheme(amount/ loan.getPayBackTimeMonths()));
    }

    private void convertYearsToMonths(final Loan loan) {
        loan.setPayBackTimeMonths(loan.getPayBackTimeYears() * 12);;
    }

    public void calculatePaymentPlan(final Loan loan) {

        Map<Integer, Double> paymentPlan = new HashMap<>();

        double monthlyPayment = loan.getPaymentScheme().getMonthlyPayment();
        double interest = loan.getInterest().getInterestRate();
        int months = loan.getPayBackTimeMonths();
        double monthlyPaymentWithInterest;

        for (int i = 1; i <= months; i++){
            monthlyPaymentWithInterest = ((loan.getLoanAmount() * interest) / 12) + monthlyPayment;
            loan.setLoanAmount(loan.getLoanAmount() - monthlyPayment);

            paymentPlan.put(i, monthlyPaymentWithInterest);
        }

        loan.setPaymentPlan(paymentPlan);

    }

    // Can be put in a seperate service that is used for sorting or other conversion. But this is quite a small system.
    public ArrayList<Integer> mapToSortedArrayList(Map<Integer, Double> paymentPlan) {
        ArrayList<Integer> sortedByStartingMonthPaymentPlan = new ArrayList<>(paymentPlan.keySet());
        Collections.sort(sortedByStartingMonthPaymentPlan);
        return sortedByStartingMonthPaymentPlan;
    }

}
