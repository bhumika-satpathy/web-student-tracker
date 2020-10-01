package com.luv2code.springdemo.services;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    CustomerDao customerDao;

    @Transactional
    @Override
    public List<Customer> getCustomers() {

        return customerDao.getCustomers();

    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {
        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }
}
