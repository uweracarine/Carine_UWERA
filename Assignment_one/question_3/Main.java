package AdvancedInternshipManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Internship> internships = new ArrayList<>();

        try {
            System.out.println("Registering a new ULK internship");

            System.out.print("Enter Student ID: ");
            String studentId = scanner.nextLine();
            System.out.print("Enter Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Enter University: ");
            String university = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            Student student = new Student(studentId, fullName, university, email);

            System.out.print("Enter Supervisor ID: ");
            String supId = scanner.nextLine();
            System.out.print("Enter Supervisor Name: ");
            String supName = scanner.nextLine();
            System.out.print("Enter Qualification: ");
            String qualification = scanner.nextLine();
            System.out.print("Enter Supervisor Email: ");
            String supEmail = scanner.nextLine();
            Supervisor supervisor = new Supervisor(supId, supName, qualification, supEmail);

            System.out.print("Enter Company ID: ");
            String companyId = scanner.nextLine();
            System.out.print("Enter Company Name: ");
            String companyName = scanner.nextLine();
            System.out.print("Enter Industry Type: ");
            String industryType = scanner.nextLine();
            System.out.print("Enter Location: ");
            String location = scanner.nextLine();
            Company company = new Company(companyId, companyName, industryType, location);

            System.out.print("Enter Internship ID: ");
            String internshipId = scanner.nextLine();
            System.out.print("Enter Start Date (YYYY-MM-DD): ");
            LocalDate start = LocalDate.parse(scanner.nextLine());
            System.out.print("Enter End Date (YYYY-MM-DD): ");
            LocalDate end = LocalDate.parse(scanner.nextLine());

            Internship ulkInternship = new ULKInternship(internshipId, student, company, supervisor, start, end, "PENDING");
            if (ulkInternship.validateInternship()) {
                internships.add(ulkInternship);
                System.out.println("Internship successfully validated and registered.");
                ulkInternship.generateReport();
            } else {
                System.out.println("Internship validation failed.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

        }
