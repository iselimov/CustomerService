package com.defrag.web.controller;

import com.defrag.model.Customer;
import com.defrag.web.dto.AddressDto;
import com.defrag.web.dto.CustomerDto;

import java.util.List;

/**
 * Controller for {@link Customer} resource.
 */
public interface CustomerController {

    List<CustomerDto> findByFirstAndLastName(String firstName, String lastName);

    CustomerDto create(CustomerDto toCreate);

    CustomerDto updateActualAddress(long id, AddressDto actualAddress);
}
