package TaxEnforcementManagementSystem;

import java.time.LocalDate;

public class PAYEDeclaration extends TaxDeclaration{
    private double grossSalary;

    public PAYEDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double grossSalary) {
        super(declarationId, taxpayerName, taxpayerTIN, declarationDate);
        this.grossSalary = grossSalary;
    }

    @Override
    public void validateDeclaration() {
        if (grossSalary <= 0) throw new IllegalArgumentException("Salary must be greater than 0");
        if (declarationDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Date cannot be in the future");
    }

    @Override
    public void enforceCompliance() {

        if (!isPaid && declarationDate.plusMonths(1).withDayOfMonth(15).isBefore(LocalDate.now())) {
            System.out.println("PAYE Penalty: Payment is overdue.");
        }
    }

    @Override
    public double calculateTax() {

        if (grossSalary <= 300000) taxAmount = 0;
        else if (grossSalary <= 500000) taxAmount = grossSalary * 0.2;
        else taxAmount = grossSalary * 0.3;
        return taxAmount;

    }

    @Override
    public void generateReceipt() {
        System.out.printf("PAYE Receipt: %s - %s - Amount: %.2f - Paid: %s\n",
                taxpayerTIN, taxpayerName, taxAmount, isPaid);
    }
}
