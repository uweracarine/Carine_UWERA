package AdvancedInternshipManagementSystem;

public class Supervisor {


    private String supervisorId;
    private String fullName;
    private String qualification;
    private String email;

    public Supervisor(String supervisorId, String fullName, String qualification, String email) {
        this.supervisorId = supervisorId;
        this.fullName = fullName;
        setQualification(qualification);
        setEmail(email);
    }

    public String getSupervisorId() { return supervisorId; }
    public String getFullName() { return fullName; }
    public String getQualification() { return qualification; }
    public String getEmail() { return email; }

    public void setQualification(String qualification) {
        if (qualification.equalsIgnoreCase("Bachelors") || qualification.equalsIgnoreCase("Masters") || qualification.equalsIgnoreCase("PhD")) {
            this.qualification = qualification;
        } else throw new IllegalArgumentException("Invalid qualification.");
    }

    public void setEmail(String email) {
        if (email.contains("@")) this.email = email;
        else throw new IllegalArgumentException("Invalid email.");
    }
}
