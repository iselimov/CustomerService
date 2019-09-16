package com.defrag.web.dto;

import com.defrag.model.Address;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto for {@link Address}.
 */
@Getter
@Setter
public class AddressDto {

    private String country;

    private String region;

    private String city;

    private String street;

    private String house;

    private String flat;
}
