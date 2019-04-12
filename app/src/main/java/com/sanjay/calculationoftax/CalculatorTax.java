package com.sanjay.calculationoftax;

public class CalculatorTax {

    double monthlySalary;
    public CalculatorTax(double monthlySalary){
        this.monthlySalary = monthlySalary;
    }

    public double getTaxAmount(){
        double taxAmount = 0;
        double yearlySalary = toYearly(this.monthlySalary);
        if ( yearlySalary > 0 && yearlySalary < 200000 ){
            //1% = 0.01
            taxAmount = (0.01 * yearlySalary );
        }
        if( yearlySalary > 199999 && yearlySalary < 350000 ){
            double taxAmountForTwohunderedThousand = 0.01 * yearlySalary;
            double salaryAfterTwoHunderedThousand = yearlySalary - 200000;
            double forRemaining = 0.15 * salaryAfterTwoHunderedThousand;
            taxAmount = taxAmountForTwohunderedThousand + forRemaining;
            if( yearlySalary == 200000 ){
                taxAmount = taxAmountForTwohunderedThousand;
            }

        }
        
        if( yearlySalary >= 350000 ){
            double taxAmountForTwohunderedThousand = 0.01 * yearlySalary;
            double taxAmountForOneFiftyThousandAfterTwohunderedThousand = 0.15 * 150000;
            double forRemainingSalary = 0.25 * (yearlySalary - 350000);
            taxAmount = taxAmountForTwohunderedThousand + taxAmountForOneFiftyThousandAfterTwohunderedThousand + forRemainingSalary;
            if(yearlySalary == 350000){
                taxAmount = taxAmountForTwohunderedThousand + taxAmountForOneFiftyThousandAfterTwohunderedThousand;
            }
        }
        return taxAmount;
    }

    private double toYearly(double monthlySalary){
        return monthlySalary * 12;
    }
}

