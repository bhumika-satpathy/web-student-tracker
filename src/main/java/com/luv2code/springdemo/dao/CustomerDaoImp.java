package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerDaoImp implements CustomerDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // Use the connection to the database by autowiring sessionFactory
        Session session = sessionFactory.getCurrentSession();

        // Create a query using Hibernate
        Query query = session.createQuery("from Customer order by firstName", Customer.class);

        // Retrieve all the objects from the database
        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        // Saves if the object is not present in the database and updates if already present
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomerById(int theId) {

        // Get current session
        Session session = sessionFactory.getCurrentSession();

        // Query the customer with id = theId
        Customer customer = session.get(Customer.class, theId);

        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {

        // Get a new session
        Session session = sessionFactory.getCurrentSession();

        // Perform the operation to delete the customer from the db
        Customer customer = session.get(Customer.class, theId);
        session.delete(customer);
    }


}
