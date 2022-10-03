package com.catscompany.catscompany.controller;


import java.awt.PageAttributes;

import com.catscompany.catscompany.Model.Company;
import com.catscompany.catscompany.Service.CompanyService;
import com.catscompany.catscompany.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1.0/market/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> createCompany(@RequestBody Company company)
    {
        return ResponseEntity.status(201).body(companyService.createCompany(company));
    }

    @GetMapping ("/info/{companyCode}")
    public ResponseEntity<Object> getCompany(@PathVariable(required = false) String companyCode)
    {

        return ResponseEntity.status(200).body(companyService.getCompanyDetails(companyCode));

    }

    @DeleteMapping("/delete/{companyCode}")
    public ResponseEntity<Object> deleteCompany(@PathVariable(required = false) String companyCode)
    {
        return ResponseEntity.status(200).body(companyService.deleteCompanyDetails(companyCode));
    }

}
