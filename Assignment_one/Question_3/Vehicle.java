package AdvancedVehicleTaxManagementSystem;

import java.util.Calendar;

public abstract class Vehicle {
    private String vehicleId;
    private String ownerName;
    private int yearOfFabrication;
    private String registrationNumber;
    private double baseTaxRate;
    private String vehicleType;

    public Vehicle(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, String vehicleType) {
        this.vehicleId = vehicleId;
        this.ownerName = ownerName;
        this.yearOfFabrication = yearOfFabrication;
        this.registrationNumber = registrationNumber;
        this.baseTaxRate = baseTaxRate;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setYearOfFabrication(int yearOfFabrication) {
        this.yearOfFabrication = yearOfFabrication;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getBaseTaxRate() {
        return baseTaxRate;
    }

    public void setBaseTaxRate(double baseTaxRate) {
        this.baseTaxRate = baseTaxRate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public abstract double calculateTax();

    public abstract void generateTaxReport();

    public String toString() {
        return "Vehicle ID: " + vehicleId + ", Owner: " + ownerName + ", Year: " + yearOfFabrication +
                ", Reg#: " + registrationNumber + ", Type: " + vehicleType;
    }
    public int getVehicleAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - yearOfFabrication;
    }
}