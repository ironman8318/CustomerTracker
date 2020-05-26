/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejendra.spring.service;

import com.tejendra.spring.dao.CustomerDAO;
import com.tejendra.spring.entity.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aman
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;
    
    @Override
    @Transactional
    public List<Customer> getCustomers() {
      return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }
    
    
    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }
    
    
    
    
    
}
