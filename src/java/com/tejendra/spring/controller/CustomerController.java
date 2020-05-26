/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejendra.spring.controller;

import com.tejendra.spring.entity.Customer;
import com.tejendra.spring.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author aman
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/list")
    public String listCustomer(Model model){
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "listCustomer";
    }
    
    @GetMapping("/addCustomerForm")
    public String addCustomerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "addCustomerForm";
    }
    
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }
    
    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId") int id , Model model){
        Customer temp = customerService.getCustomer(id);
        model.addAttribute("customer",temp);
        return "addCustomerForm";
    }
    
    
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int id , Model model){
        customerService.deleteCustomer(id);
//        model.addAttribute("customer",temp);
        return "redirect:/customer/list";
    }
}
