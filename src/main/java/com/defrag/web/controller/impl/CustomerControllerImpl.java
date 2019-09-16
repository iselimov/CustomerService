package com.defrag.web.controller.impl;

import com.defrag.model.Address;
import com.defrag.model.Customer;
import com.defrag.service.CustomerService;
import com.defrag.web.controller.CustomerController;
import com.defrag.web.dto.AddressDto;
import com.defrag.web.dto.CustomerDto;
import com.defrag.web.mapper.AddressMapper;
import com.defrag.web.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/customers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService service;
    private final CustomerMapper mapper;
    private final AddressMapper addressMapper;

    @GetMapping
    @Override
    public List<CustomerDto> findByFirstAndLastName(@RequestParam String firstName,
                                                    @RequestParam String lastName) {
        return service.findByFirstAndLastName(firstName, lastName)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @Override
    public CustomerDto create(@Valid @RequestBody CustomerDto toCreate) {
        Customer newCustomer = mapper.fromDto(toCreate);
        return mapper.toDto(service.create(newCustomer));
    }

    @PutMapping("{id}/actualAddress")
    @Override
    public CustomerDto updateActualAddress(@PathVariable long id,
                                           @Valid @RequestBody AddressDto actualAddress) {
        Address newActualAddress = addressMapper.fromDto(actualAddress);
        return mapper.toDto(service.updateActualAddress(id, newActualAddress));
    }
}
