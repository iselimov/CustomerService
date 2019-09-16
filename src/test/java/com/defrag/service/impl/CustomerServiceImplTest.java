package com.defrag.service.impl;

import com.defrag.exception.EntityNotFoundException;
import com.defrag.model.Address;
import com.defrag.model.Customer;
import com.defrag.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private AddressCopier addressCopier;
    @InjectMocks
    private CustomerServiceImpl service;

    @Test(expected = EntityNotFoundException.class)
    public void testUpdate_When_CustomerWasNotFound() {
        mockCustomerRepository(Optional.empty());

        // null address is ok here
        service.updateActualAddress(1, null);
    }

    @Test
    public void testUpdate_When_CustomerWasFound() {
        Customer updatingCustomer = new Customer();
        updatingCustomer.setActualAddress(new Address());
        mockCustomerRepository(Optional.of(updatingCustomer));

        Address newActualAddress = new Address();
        service.updateActualAddress(1, newActualAddress);

        verify(addressCopier, times(1))
                .copy(newActualAddress, updatingCustomer.getActualAddress());
        verify(customerRepository, times(1))
                .save(updatingCustomer);
    }

    private void mockCustomerRepository(Optional<Customer> result) {
        doReturn(result)
                .when(customerRepository)
                .findById(anyLong());
    }
}
