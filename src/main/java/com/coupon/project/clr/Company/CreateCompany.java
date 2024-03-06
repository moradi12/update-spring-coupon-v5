package com.coupon.project.clr.Company;

import com.coupon.project.database.Exceptions.CompanyNotFoundException;
import com.coupon.project.database.Exceptions.ErrMsg;
import com.coupon.project.database.Service.CompanyService;
import com.coupon.project.database.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.List;

//@Component
@Order(3)
public class CreateCompany implements CommandLineRunner {

    @Autowired
    CompanyService companyService;


    /**
     * Creates and saves sample companies
     * @param args Command line arguments
     * @throws Exception If an error occurs during execution
     */


    @Override
    public void run(String... args) throws Exception {
        System.out.println("creating some companies...");
        try {
            List<Company> companies = Arrays.asList(
                    Company.builder()
                            .name("Nike")
                            .email("Nike@Nike.com")
                            .password("3232gg")
                            .build(),

                    Company.builder()
                            .name("Prada")
                            .email("Prada@Prada.com")
                            .password("Prada789")
                            .build()
            );
            // Save all companies
            companyService.saveAll(companies);
        } catch (CompanyNotFoundException e) {
            throw new CompanyNotFoundException(ErrMsg.DATABASE_CONNECTION_ERROR.getMsg());
        }
    }
}

