package com.catscompany.catscompany.Service;

import java.util.Arrays;
import java.util.List;

import com.catscompany.catscompany.Model.Company;
import com.catscompany.catscompany.Model.Stock;
import com.catscompany.catscompany.repository.CompanyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompanyServiceImplementation implements  CompanyService{

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    RestTemplate restTemplate;

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
        deleteStockInfo(companyCode);
        companyRepository.deleteById(companyRepository.findCompanyDetails(companyCode).getCid());
        return company;
    }

    private void deleteStockInfo(String companyCode) {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity httpHeaders=new HttpEntity<String>("parameters",headers);
        System.out.println("calling Company service");
        ResponseEntity<Object> responseEntity=restTemplate.exchange("http://stock-service/api/v1.0/market/stock/deleteStocks/"+companyCode, HttpMethod.DELETE,httpHeaders,Object.class);
        Object clazz;
        clazz= Stock.class;
        Stock response=objectMapper
            .convertValue(
                responseEntity.getBody(), Stock.class);

    }

    @Override
    public List<Company> getCompanies() {

        return companyRepository.fetchAllCompanies();
    }
}
