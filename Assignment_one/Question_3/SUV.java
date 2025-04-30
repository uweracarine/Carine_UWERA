package AdvancedVehicleTaxManagementSystem;

public class SUV extends Vehicle{
    private boolean fourWheelDrive;
    private double baseTaxRate;

    public SUV(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, String vehicleType, boolean fourWheelDrive) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, vehicleType);
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate;
        if (fourWheelDrive) tax *= 1.1;
        if (getVehicleAge() > 10) tax *= 0.95;
        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println(toString());
        System.out.println("Calculated Tax: " + calculateTax());
    }
}
