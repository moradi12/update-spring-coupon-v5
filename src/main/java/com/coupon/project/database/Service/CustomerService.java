package com.coupon.project.database.Service;

import com.coupon.project.database.beans.Customer;
import com.coupon.project.database.Exceptions.CustomerException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    boolean isCustomerExists(String email, String password) throws CustomerException;

    void addCustomer(Customer customer) throws CustomerException;
    void saveCustomer(Customer customer) throws CustomerException;


    void updateCustomer(Customer customer) throws CustomerException;

    void deleteCustomer(int customerID);

    Optional<Customer> getOneCustomer(int customerID) throws CustomerException;


    List<Customer> getAllCustomers();
}
