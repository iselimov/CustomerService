package com.defrag.service;

import com.defrag.model.Address;
import com.defrag.model.Customer;

import java.util.List;

/**
 * Service for working with {@link Customer}.
 */
public interface CustomerService {

    List<Customer> findByFirstAndLastName(String firstName, String lastName);

    Customer create(Customer toCreate);

    Customer updateActualAddress(long id, Address newActualAddress);
}
