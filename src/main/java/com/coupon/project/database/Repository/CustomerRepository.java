package com.coupon.project.database.Repository;

import com.coupon.project.database.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByEmailAndPassword(String email, String password);
    Boolean existsByEmail(String email);


    List<Customer> findById(int id);

    List<Customer> findByName(String name);

    List<Customer> findByNameOrId(String name, int id);

    List<Customer> findAllByName(String name);
}
