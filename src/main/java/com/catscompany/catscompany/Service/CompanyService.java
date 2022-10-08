package com.catscompany.catscompany.Service;

import com.catscompany.catscompany.Model.Company;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    Company createCompany(Company company);
    Company getCompanyDetails(String companyCode);
    Company deleteCompanyDetails(String companyCode);

}
