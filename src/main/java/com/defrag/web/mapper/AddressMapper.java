package com.defrag.web.mapper;

import com.defrag.model.Address;
import com.defrag.web.dto.AddressDto;
import org.mapstruct.Mapper;

/**
 * Mapper for {@link Address}.
 */
@Mapper
public interface AddressMapper {

    Address fromDto(AddressDto source);
}
