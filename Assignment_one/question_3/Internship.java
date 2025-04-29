package AdvancedInternshipManagementSystem;

import java.time.LocalDate;

public abstract class Internship {

    protected String internshipId;
    protected Student student;
    protected Company company;
    protected Supervisor supervisor;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected String status; // PENDING, ONGOING, COMPLETED

    public Internship(String internshipId, Student student, Company company, Supervisor supervisor,
                      LocalDate startDate, LocalDate endDate, String status) {
        this.internshipId = internshipId;
        this.student = student;
        this.company = company;
        this.supervisor = supervisor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public boolean isValidDuration() {
        return startDate.isBefore(endDate) && java.time.temporal.ChronoUnit.WEEKS.between(startDate, endDate) >= 6;
    }

    public abstract void assignSupervisor();
    public abstract void trackProgress();
    public abstract void generateReport();
    public abstract boolean validateInternship();
}
