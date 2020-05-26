/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejendra.spring.dao;

import com.tejendra.spring.entity.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aman
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
            
    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> q = session.createQuery("from Customer order By id",Customer.class);
        List<Customer> customers = q.getResultList();
        
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(customer.getId());
       
        session.saveOrUpdate(customer);
       
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class,id);
    }
    
    
    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer temp = session.get(Customer.class,id);
        session.delete(temp);
//        return session.get(Customer.class,id);
    }
    
    
    
    
    
}
