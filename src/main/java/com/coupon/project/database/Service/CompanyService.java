package com.coupon.project.database.Service;

import com.coupon.project.database.beans.Company;
import com.coupon.project.database.Exceptions.CompanyNotFoundException;

import java.util.List;

public interface CompanyService {

    boolean isCompanyExists(String email, String password) throws CompanyNotFoundException;
    void addCompany(Company company) throws CompanyNotFoundException;
    void updateCompany(Company company) throws CompanyNotFoundException;
    void deleteCompany(int companyID);
    List<Company> getAllCompanies();
    Company getOneCompany(int companyID) throws CompanyNotFoundException;

    void saveAll(List<Company> companies) throws CompanyNotFoundException;
}
