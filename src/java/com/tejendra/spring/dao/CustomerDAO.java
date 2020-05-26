/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejendra.spring.dao;

import com.tejendra.spring.entity.Customer;
import java.util.List;

/**
 *
 * @author aman
 */
public interface CustomerDAO {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
}
