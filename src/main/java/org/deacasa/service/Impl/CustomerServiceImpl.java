package org.deacasa.service.Impl;

import org.deacasa.entity.Customer;
import org.deacasa.repository.CustomerRepo;
import org.deacasa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private  final CustomerRepo customerRepo;
    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo){this.customerRepo=customerRepo;}


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("Customer not found"));
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customer1=getCustomerById(id);
        customer1.setUserId(customer.getUserId());
        customer1.setLocationId(customer.getLocationId());
        return customerRepo.save(customer1);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);

    }
}
