package AdvancedInternshipManagementSystem;

import java.time.LocalDate;

public class ULKInternship extends Internship{

    public ULKInternship(String internshipId, Student student, Company company, Supervisor supervisor,
                         LocalDate startDate, LocalDate endDate, String status) {
        super(internshipId, student, company, supervisor, startDate, endDate, status);
    }

    @Override
    public void assignSupervisor() {
        System.out.println("ULK Supervisor assigned: " + supervisor.getFullName());
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking progress for ULK internship of " + student.getFullName());
    }

    @Override
    public void generateReport() {
        System.out.println("Internship Report: ");
        System.out.println("Student: " + student.getFullName());
        System.out.println("University: " + student.getUniversity());
        System.out.println("Company: " + company.getName());
        System.out.println("Supervisor: " + supervisor.getFullName());
        System.out.println("Duration: " + startDate + " to " + endDate);
        System.out.println("Status: " + status);
    }

    @Override
    public boolean validateInternship() {
        boolean isULK = student.getUniversity().equalsIgnoreCase("ULK");
        boolean isQualified = supervisor.getQualification().equalsIgnoreCase("Masters") ||
                supervisor.getQualification().equalsIgnoreCase("PhD");
        return isULK && isQualified && isValidDuration();
    }
}
