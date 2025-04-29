package AdvancedInternshipManagementSystem;

public class Student {
    private String studentId;
    private String fullName;
    private String university;
    private String email;

    public Student(String studentId, String fullName, String university, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        setUniversity(university);
        setEmail(email);
    }

    public String getStudentId() { return studentId; }
    public String getFullName() { return fullName; }
    public String getUniversity() { return university; }
    public String getEmail() { return email; }

    public void setUniversity(String university) {
        if (university.equalsIgnoreCase("ULK") || university.equalsIgnoreCase("UR") ||
                university.equalsIgnoreCase("AUCA") || university.equalsIgnoreCase("UK")) {
            this.university = university;
        } else throw new IllegalArgumentException("Invalid university name.");
    }

    public void setEmail(String email) {
        if (email.contains("@")) this.email = email;
        else throw new IllegalArgumentException("Invalid email.");
    }
}
