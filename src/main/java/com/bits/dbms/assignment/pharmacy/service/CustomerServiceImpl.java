package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Customer;
import com.bits.dbms.assignment.pharmacy.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.orElse(null);
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer newCustomer) {
        newCustomer.setCreated_on(new Date());
        newCustomer.setModified_on(null);
        newCustomer.setModified_by(null);
        return customerRepository.save(newCustomer);
    }

    @Override
    public Customer updateCustomer(Customer updateCustomer) {
        if (updateCustomer.getCustomer_id() == null) {
            return saveCustomer(updateCustomer);
        }
        Customer customer = findCustomerById(updateCustomer.getCustomer_id());
        if (customer != null) {
            customer.setAddress_id(updateCustomer.getCustomer_id());
            customer.setEmail_id(updateCustomer.getEmail_id());
            customer.setCustomer_dob(updateCustomer.getCustomer_dob());
            customer.setMobile_no(updateCustomer.getMobile_no());
            customer.setName(updateCustomer.getName());
            customer.setModified_on(new Date());
            return customerRepository.save(customer);
        } else {
            return saveCustomer(updateCustomer);
        }
    }
}
