package TaxEnforcementManagementSystem;

import java.time.LocalDate;

public class VATDeclaration extends TaxDeclaration{


    private double sales;
    private double purchases;

    public VATDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double sales, double purchases) {
        super(declarationId, taxpayerName, taxpayerTIN, declarationDate);
        this.sales = sales;
        this.purchases = purchases;
    }

    @Override
    public void validateDeclaration() {
        if (sales <= purchases) throw new IllegalArgumentException("Sales must exceed purchases");
        if (declarationDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Date cannot be in the future");
    }

    @Override
    public void enforceCompliance() {

        if (!isPaid) {
            System.out.println("VAT Penalty: Unpaid VAT will incur interest.");
        }
    }

    @Override
    public double calculateTax() {

        taxAmount = sales * 0.18;
        return taxAmount;
    }

    @Override
    public void generateReceipt() {

        System.out.printf("VAT Receipt: %s - %s - Amount: %.2f - Paid: %s\n",
                taxpayerTIN, taxpayerName, taxAmount, isPaid);
    }
    }

