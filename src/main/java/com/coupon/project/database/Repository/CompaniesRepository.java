package com.coupon.project.database.Repository;

import com.coupon.project.database.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompaniesRepository extends JpaRepository<Company, Integer> {
    Boolean existsByEmailAndPassword(String email, String password);
    Boolean existsByNameOrEmail(String name, String email);


    List<Company> findAll();

    List<Company> findByName(String name);

    List<Company> findByNameID(int id);

    Company save(Company company);

    void deleteById(int companyId);
}
