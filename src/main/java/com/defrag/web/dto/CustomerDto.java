package com.defrag.web.dto;

import com.defrag.model.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Dto for {@link Customer}.
 */
@Getter
@Setter
public class CustomerDto {

    @NotNull
    private AddressDto registeredAddress;

    @NotNull
    private AddressDto actualAddress;

    private String firstName;

    private String lastName;

    private String middleName;

    @NotNull
    private Customer.Sex sex;
}
