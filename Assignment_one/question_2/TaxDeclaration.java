package TaxEnforcementManagementSystem;

import java.time.LocalDate;

import  java.time.LocalDate;
public abstract class TaxDeclaration implements Interface,Receiptable{
    protected String declarationId;
    protected String taxpayerName;
    protected String taxpayerTIN;
    protected LocalDate declarationDate;
    protected double taxAmount;
    protected boolean isPaid;

    public TaxDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate) {
        this.declarationId = declarationId;
        this.taxpayerName = taxpayerName;
        this.taxpayerTIN = taxpayerTIN;
        this.declarationDate = declarationDate;
        this.taxAmount = 0.0;
        this.isPaid = false;
    }

    public abstract void validateDeclaration();
    public abstract void enforceCompliance();
}

