package com.kodat.of.companyms.service;




import com.kodat.of.companyms.dto.ReviewMessage;
import com.kodat.of.companyms.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    boolean updateCompany(Long id ,Company company);

    void createCompany(Company company);
    boolean deleteCompany(Long id);

    Company getCompanyById(Long id);
    public void updateCompanyRating(ReviewMessage reviewMessage);
}
