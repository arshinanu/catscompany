package com.catscompany.catscompany.Service;

import java.util.List;

import com.catscompany.catscompany.Model.Company;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    Company createCompany(Company company);
    Company getCompanyDetails(String companyCode);
    Company deleteCompanyDetails(String companyCode);
    List<Company> getCompanies();

}
