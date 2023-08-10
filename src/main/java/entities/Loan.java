package entities;

import entities.enums.LoanType;

import java.util.Map;

public class Loan {

    //sätta alla fält som final

    /*istället för att använda setters på det sättet jag gjort här. Bygga mer objektorienterat när det kommer till
    paymentplan och loan amount
    har byggt en konstig depedency mellan paymentscheme och loan.
     */



    private final LoanType loanType;
    private final Interest interest;
    private double loanAmount;
    private final int payBackTimeYears;
    private int payBackTimeMonths;
    private PaymentScheme paymentScheme;
    private Map<Integer, Double> paymentPlan;

    public Loan (double loanAmount, int payBackTimeYears, Interest interest) {
        this.loanType = interest.getLoanType();
        this.interest = interest;
        this.loanAmount = loanAmount;
        this.payBackTimeYears = payBackTimeYears;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public Interest getInterest() {
        return interest;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getPayBackTimeYears() {
        return payBackTimeYears;
    }

    public void setPaymentScheme(PaymentScheme paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public PaymentScheme getPaymentScheme() {
        return paymentScheme;
    }

    public Map<Integer, Double> getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(Map<Integer, Double> paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public void setPayBackTimeMonths(int payBackTimeMonths) {
        this.payBackTimeMonths = payBackTimeMonths;
    }

    public int getPayBackTimeMonths() {
        return payBackTimeMonths;
    }
}
