package AdvancedVehicleTaxManagementSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Vehicle> vehicleList = new ArrayList<>();
    private static final Set<String> vehicleIds = new HashSet<>();
    private static final Set<String> registrationNumbers = new HashSet<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n====== Vehicle Tax Management System ======");
            System.out.println("1. Register a Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Calculate Tax");
            System.out.println("4. Generate Reports");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = getIntInput();

            if (option == 1) {
                registerVehicle();
            } else if (option == 2) {
                viewVehicles();
            } else if (option == 3) {
                calculateTaxes();
            } else if (option == 4) {
                generateReports();
            } else if (option == 5) {
                System.out.println("Exiting program. Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    private static void registerVehicle() {
        System.out.print("Enter Vehicle Type (Car, Truck, Motorcycle, Bus, SUV): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter Vehicle ID: ");
        String id = scanner.nextLine();
        if (vehicleIds.contains(id)) {
            System.out.println("This Vehicle ID already exists.");
            return;
        }

        System.out.print("Enter Owner Name: ");
        String owner = scanner.nextLine();

        System.out.print("Enter Year of Fabrication: ");
        int year = getIntInput();
        int currentYear = java.time.Year.now().getValue();
        if (year > currentYear) {
            System.out.println("Year cannot be in the future.");
            System.out.println("retry");
            return;
        }

        System.out.print("Enter Registration Number: ");
        String reg = scanner.nextLine();
        if (registrationNumbers.contains(reg)) {
            System.out.println("This Registration Number already exists.");
            return;
        }

        System.out.print("Enter Base Tax Rate: ");
        double baseTax = getDoubleInput();

        Vehicle vehicle = null;

        if (type.equals("car")) {
            System.out.print("Is it electric (true/false): ");
            boolean isElectric = Boolean.parseBoolean(scanner.nextLine());
            vehicle = new Car(id, owner, year, reg, baseTax, "Car", isElectric);
        } else if (type.equals("truck")) {
            System.out.print("Enter Load Capacity (tons): ");
            double load = getDoubleInput();
            if (load <= 0) {
                System.out.println("Load must be greater than 0.");
                return;
            }
            vehicle = new Truck(id, owner, year, reg, baseTax, "Truck", load);
        } else if (type.equals("motorcycle")) {
            System.out.print("Enter Engine Capacity (cc): ");
            int cc = getIntInput();
            if (cc <= 0) {
                System.out.println("Engine capacity must be greater than 0.");
                return;
            }
            vehicle = new Motorcycle(id, owner, year, reg, baseTax, "Motorcycle", cc);
        } else if (type.equals("bus")) {
            System.out.print("Enter Passenger Capacity: ");
            int cap = getIntInput();
            if (cap <= 0) {
                System.out.println("Passenger capacity must be greater than 0.");
                return;
            }
            vehicle = new Bus(id, owner, year, reg, baseTax, "Bus", cap);
        } else if (type.equals("suv")) {
            System.out.print("Is it 4WD (true/false): ");
            boolean is4WD = Boolean.parseBoolean(scanner.nextLine());
            vehicle = new SUV(id, owner, year, reg, baseTax, "SUV", is4WD);
        } else {
            System.out.println("Unknown vehicle type.");
            return;
        }

        vehicleList.add(vehicle);
        vehicleIds.add(id);
        registrationNumbers.add(reg);
        System.out.println("Vehicle registered successfully.");
    }

    private static void viewVehicles() {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles registered.");
        } else {
            for (Vehicle v : vehicleList) {
                System.out.println(v);
            }
        }
    }

    private static void calculateTaxes() {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles registered.");
        } else {
            for (Vehicle v : vehicleList) {
                System.out.println("Tax for " + v.getVehicleId() + ": " + v.calculateTax());
            }
        }
    }

    private static void generateReports() {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles registered.");
        } else {
            for (Vehicle v : vehicleList) {
                v.generateTaxReport();
            }
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    private static double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid decimal number: ");
            }
        }
    }
}

