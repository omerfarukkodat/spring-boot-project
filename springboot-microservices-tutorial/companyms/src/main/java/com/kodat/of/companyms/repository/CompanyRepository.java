package com.kodat.of.companyms.repository;


import com.kodat.of.companyms.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
