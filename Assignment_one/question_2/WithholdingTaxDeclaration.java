package TaxEnforcementManagementSystem;

import java.time.LocalDate;

public class WithholdingTaxDeclaration extends TaxDeclaration{


    private String category; // rent, dividend, service
    private double amount;

    public WithholdingTaxDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, String category, double amount) {
        super(declarationId, taxpayerName, taxpayerTIN, declarationDate);
        this.category = category;
        this.amount = amount;
    }

    @Override
    public void validateDeclaration() {

        if (!(category.equals("rent") || category.equals("dividend") || category.equals("service")))
            throw new IllegalArgumentException("Invalid category");
        if (declarationDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Date cannot be in the future");
    }

    @Override
    public void enforceCompliance() {
        if (!isPaid) {
            System.out.println("Withholding Tax Penalty: Must be declared before payment.");
        }
    }

    @Override
    public double calculateTax() {

        switch (category) {
            case "service": taxAmount = amount * 0.15; break;
            case "rent": taxAmount = amount * 0.10; break;
            case "dividend": taxAmount = amount * 0.05; break;
        }
        return taxAmount;
    }

    @Override
    public void generateReceipt() {

        System.out.printf("Withholding Receipt: %s - %s - Category: %s - Amount: %.2f - Paid: %s\n",
                taxpayerTIN, taxpayerName, category, taxAmount, isPaid);
    }
    }

