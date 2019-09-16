package com.defrag.repository;

import com.defrag.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring data repository for working with {@link Customer}.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByFirstNameAndLastName(String firstName, String lastName);
}
