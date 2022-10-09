package com.catscompany.catscompany.repository;

import javax.transaction.Transactional;

import java.util.List;

import com.catscompany.catscompany.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    @Query("from Company where company_code=:companyCode")
    public Company findCompanyDetails(String companyCode);

    @Query (value = "select distinct c from Company c ")
    public List<Company> fetchAllCompanies();
}
