package com.defrag.service.impl;

import com.defrag.exception.EntityNotFoundException;
import com.defrag.model.Address;
import com.defrag.model.Customer;
import com.defrag.repository.CustomerRepository;
import com.defrag.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final AddressCopier addressCopier;

    @Transactional(readOnly = true)
    @Override
    public List<Customer> findByFirstAndLastName(String firstName, String lastName) {
        return repository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    @Transactional
    @Override
    public Customer create(Customer toCreate) {
        return repository.save(toCreate);
    }

    @Transactional
    @Override
    public Customer updateActualAddress(long id, Address newActualAddress) {
        Customer existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Customer.class, id));

        addressCopier.copy(newActualAddress, existing.getActualAddress());

        return repository.save(existing);
    }
}
