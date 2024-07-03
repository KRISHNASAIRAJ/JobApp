package com.devop.JobApp.company;


import java.util.List;
//The business logic is implemented here so to prevent code from getting polluted we will implement separately
public interface CompanyService {
    List<Company> getAllCompanies();
    void createCompany(Company company);
    boolean updateCompany(Long id, Company company);
    boolean deleteCompany(Long id);
    Company getCompanyById(Long id);
}
