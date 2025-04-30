package AdvancedVehicleTaxManagementSystem;

public class Bus extends Vehicle{

    private int passengerCapacity;
    private double baseTaxRate;

    public Bus(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, String vehicleType, int passengerCapacity) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, vehicleType);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate * (1 + (passengerCapacity / 10) * 0.02);
        if (getVehicleAge() > 20) tax *= 1.1;
        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println(toString());
        System.out.println("Calculated Tax: " + calculateTax());
    }
}
