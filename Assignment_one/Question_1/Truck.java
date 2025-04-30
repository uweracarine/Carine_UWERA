package AdvancedVehicleTaxManagementSystem;

public class Truck extends Vehicle{

    private double loadCapacity;
    private double baseTaxRate;

    public Truck(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, String vehicleType, double loadCapacity) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, vehicleType);
        if (loadCapacity <= 0) throw new IllegalArgumentException("Load capacity must be positive.");
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        if (getVehicleAge() > 15) tax *= 1.15;
        if (loadCapacity > 10) tax *= 1.25;
        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println(toString());
        System.out.println("Calculated Tax: " + calculateTax());
    }
    }

