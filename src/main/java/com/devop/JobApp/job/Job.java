package com.devop.JobApp.job;

import com.devop.JobApp.company.Company;
import jakarta.persistence.*;

@Entity
//@Table(name="job_table")
public class Job {
    // it is primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//Job I'd which is automatically generated
    private String title;//Job Title
    private String description;//Job Description
    private String minSalary;//Minimum Salary
    private String maxSalary;//Maximum Salary
    private String location;//Job Location

    @ManyToOne//Many Jobs Are Mapped To One Company
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    //Parameterized Constructor
    public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Job() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
