package com.defrag.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Address model.
 */
@Getter
@Setter
@Table(name = "address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_gen")
    @SequenceGenerator(name = "address_id_gen", sequenceName = "address_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "flat")
    private String flat;

    @Column(name = "created")
    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime created;

    @Column(name = "modified")
    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime modified;

    @PrePersist
    private void prePersist() {
        created = LocalDateTime.now();
        modified = created;
    }

    @PreUpdate
    private void preUpdate() {
        modified = LocalDateTime.now();
    }
}
