import entities.Interest;
import entities.Loan;
import entities.PaymentScheme;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.LoanCalculationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoanCalculationServiceTest {

    private Interest interest;
    private Loan loan;
    private LoanCalculationService loanCalculationService;
    private Map<Integer, Double> expectedPaymentPlan = new HashMap<>();


    @BeforeEach
    public void setup(){
        this.interest = new Interest();
        this.loan = new Loan(1000_000.0, 2, interest);
        this.loanCalculationService = new LoanCalculationService();
    }

    @Test
    public void ShouldCalculateMonthlyPayment_When_calculateMonthlyPayment_IsCalled() {
        PaymentScheme expectedMonthlyPayment = new PaymentScheme(1000_000.0/24);
        loan.setPaymentScheme(expectedMonthlyPayment);
        int expectedMonths = 24;
        loanCalculationService.calculateMonthlyPaymentForPaymentSchemeOnLoan(loan);
        Assertions.assertEquals(loan.getPaymentScheme().getMonthlyPayment(), expectedMonthlyPayment.getMonthlyPayment());
        Assertions.assertEquals(loan.getPayBackTimeMonths(), expectedMonths);
    }

    @Test
    public void ShouldCalculatePaymentPlan_When_calculatePaymentPlan_IsCalled(){
        Loan loanOneYear = new Loan(1000_000.0, 1, interest);
        loanCalculationService.calculateMonthlyPaymentForPaymentSchemeOnLoan(loanOneYear);

        expectedPaymentPlan.put(1, 86250.0);
        expectedPaymentPlan.put(2, 86006.94444444444);
        expectedPaymentPlan.put(3, 85763.88888888889);
        expectedPaymentPlan.put(4, 85520.83333333333);
        expectedPaymentPlan.put(5, 85277.77777777777);
        expectedPaymentPlan.put(6, 85034.72222222222);
        expectedPaymentPlan.put(7, 84791.66666666666);
        expectedPaymentPlan.put(8, 84548.61111111111);
        expectedPaymentPlan.put(9, 84305.55555555555);
        expectedPaymentPlan.put(10, 84062.5);
        expectedPaymentPlan.put(11, 83819.44444444444);
        expectedPaymentPlan.put(12, 83576.38888888889);

        loanCalculationService.calculatePaymentPlan(loanOneYear);

        Assertions.assertEquals(loanOneYear.getPaymentPlan(), expectedPaymentPlan);
    }

    @Test
    public void ShouldReturnSortedArrayList_When_MapToSortedArrayList_IsCalled() {
        Loan loanOneYear = new Loan(1000_000.0, 1, interest);
        loanCalculationService.calculateMonthlyPaymentForPaymentSchemeOnLoan(loanOneYear);

        expectedPaymentPlan.put(1, 86250.0);
        expectedPaymentPlan.put(2, 86006.94444444444);
        expectedPaymentPlan.put(3, 85763.88888888889);
        expectedPaymentPlan.put(4, 85520.83333333333);
        expectedPaymentPlan.put(5, 85277.77777777777);
        expectedPaymentPlan.put(6, 85034.72222222222);
        expectedPaymentPlan.put(7, 84791.66666666666);
        expectedPaymentPlan.put(8, 84548.61111111111);
        expectedPaymentPlan.put(9, 84305.55555555555);
        expectedPaymentPlan.put(10, 84062.5);
        expectedPaymentPlan.put(11, 83819.44444444444);
        expectedPaymentPlan.put(12, 83576.38888888889);

        loanCalculationService.calculatePaymentPlan(loanOneYear);

        ArrayList<Integer> expectedSortedPaymentPlanList = new ArrayList<>();
        ArrayList<Integer> actualSortedPaymentPlanList = loanCalculationService.mapToSortedArrayList(loanOneYear.getPaymentPlan());

        expectedSortedPaymentPlanList.add(1);
        expectedSortedPaymentPlanList.add(2);
        expectedSortedPaymentPlanList.add(3);
        expectedSortedPaymentPlanList.add(4);
        expectedSortedPaymentPlanList.add(5);
        expectedSortedPaymentPlanList.add(6);
        expectedSortedPaymentPlanList.add(7);
        expectedSortedPaymentPlanList.add(8);
        expectedSortedPaymentPlanList.add(9);
        expectedSortedPaymentPlanList.add(10);
        expectedSortedPaymentPlanList.add(11);
        expectedSortedPaymentPlanList.add(12);

        Assertions.assertEquals(expectedSortedPaymentPlanList, actualSortedPaymentPlanList);


    }




}
