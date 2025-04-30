package AdvancedVehicleTaxManagementSystem;

public class Motorcycle extends Vehicle{

    private int engineCapacity;
    private int baseTaxRate;

    public Motorcycle(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, String vehicleType, int engineCapacity) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, vehicleType);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        if (engineCapacity > 500) tax *= 1.2;
        tax *= 1 - (getVehicleAge() / 5) * 0.05;
        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println(toString());
        System.out.println("Calculated Tax: " + calculateTax());
    }
    }

