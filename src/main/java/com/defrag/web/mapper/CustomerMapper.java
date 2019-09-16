package com.defrag.web.mapper;

import com.defrag.model.Customer;
import com.defrag.web.dto.CustomerDto;
import org.mapstruct.Mapper;

/**
 * Mapper for {@link Customer}.
 */
@Mapper(uses = AddressMapper.class)
public interface CustomerMapper {

    Customer fromDto(CustomerDto source);

    CustomerDto toDto(Customer source);
}
