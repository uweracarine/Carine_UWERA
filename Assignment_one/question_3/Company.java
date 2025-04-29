package AdvancedInternshipManagementSystem;

import java.util.Arrays;
import java.util.List;

public class Company {

    private String companyId;
    private String name;
    private String industryType;
    private String location;

    public Company(String companyId, String name, String industryType, String location) {
        this.companyId = companyId;
        this.name = name;
        setIndustryType(industryType);
        this.location = location;
    }

    public String getCompanyId() { return companyId; }
    public String getName() { return name; }
    public String getIndustryType() { return industryType; }
    public String getLocation() { return location; }

    public void setIndustryType(String industryType) {
        List<String> validTypes = Arrays.asList("IT", "Finance", "Health", "Education");
        if (validTypes.contains(industryType)) this.industryType = industryType;
        else throw new IllegalArgumentException("Invalid industry type.");
    }
}
