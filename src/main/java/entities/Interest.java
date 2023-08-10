package entities;

import entities.enums.LoanType;

public class Interest {

    //sätta alla fält som final

    private final double DEFAULT_FIXED_INTEREST_RATE = 0.035;
    private double interestRate;
    private LoanType loanType;


    public Interest () {
        this.interestRate = DEFAULT_FIXED_INTEREST_RATE;
        this.loanType = LoanType.HOUSELOAN;
    }


    // Can be used when implementing more loantypes with different interest rates
    public Interest (LoanType loanType, double interestRate) {
        this.loanType = loanType;
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public LoanType getLoanType() {
        return loanType;
    }


}
