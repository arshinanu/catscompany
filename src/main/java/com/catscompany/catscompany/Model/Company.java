package com.catscompany.catscompany.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Company {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  cid;
    @Column(name = "company_code",unique = true)
    private String companyCode;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_ceo")
    private String companyCeo;
    @Column(name = "company_turn_over")
    private double companyTurnOver;
    @Column(name = "company_website")
    private String companyWebsite;
    @Column(name = "stock_exchange")
     private String stockExchange;
}
