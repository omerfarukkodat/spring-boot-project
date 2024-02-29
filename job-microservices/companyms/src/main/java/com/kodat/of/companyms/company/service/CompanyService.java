package com.kodat.of.companyms.company.service;


import com.kodat.of.companyms.company.dto.ReviewMessage;
import com.kodat.of.companyms.company.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    boolean updateCompany(Long id ,Company company);

    void createCompany(Company company);
    boolean deleteCompany(Long id);

    Company getCompanyById(Long id);
    public void updateCompanyRating(ReviewMessage reviewMessage);
}
