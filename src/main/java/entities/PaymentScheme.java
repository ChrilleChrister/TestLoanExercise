package entities;

public class PaymentScheme {

    //sätta alla fält som final

    //Add possible payment schemes for example quarterly, half-year, yearly
    private double monthlyPayment;

    public PaymentScheme(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }
}
