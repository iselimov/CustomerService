package com.defrag.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Customer model.
 */
@Getter
@Setter
@Table(name = "customer")
@Entity
public class Customer {

    @Id
    private Long id;

    @Column(name = "registered_address", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Address registeredAddress;

    @Column(name = "actual_address", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Address actualAddress;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "sex", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @RequiredArgsConstructor
    public enum Sex {
        MALE,
        FEMALE
    }
}
