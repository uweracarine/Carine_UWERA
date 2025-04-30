package AdvancedVehicleTaxManagementSystem;

public class Car extends Vehicle{

    private boolean isElectric;
    private double baseTaxRate;

    public Car(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, String vehicleType, boolean isElectric) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, vehicleType);
        this.isElectric = isElectric;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        if (getVehicleAge() > 10) tax *= 0.9;
        if (isElectric) tax *= 0.8;
        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println(toString());
        System.out.println("Calculated Tax: " + calculateTax());
    }
    }

