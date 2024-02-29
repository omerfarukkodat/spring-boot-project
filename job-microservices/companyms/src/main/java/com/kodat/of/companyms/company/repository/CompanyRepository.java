package com.kodat.of.companyms.company.repository;

import com.kodat.of.companyms.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
