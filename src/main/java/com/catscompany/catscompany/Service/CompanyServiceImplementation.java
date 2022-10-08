package com.catscompany.catscompany.Service;

import java.util.List;

import com.catscompany.catscompany.Model.Company;
import com.catscompany.catscompany.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImplementation implements  CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyDetails(String companyCode) {
        return companyRepository.findCompanyDetails(companyCode);
    }


    @Override
    public Company deleteCompanyDetails(String companyCode) {
        Company company=Company.builder().companyCode(companyCode).build();
        companyRepository.deleteById(companyRepository.findCompanyDetails(companyCode).getCid());
        return company;
    }

    @Override
    public List<Company> getCompanies() {

        return companyRepository.fetchAllCompanies();
    }
}
