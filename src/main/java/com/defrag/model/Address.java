package com.defrag.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Address model.
 */
@Getter
@Setter
@Table(name = "customer")
@Entity
public class Address {

    @Id
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

    @Column(name = "create")
    private LocalDateTime created;

    @Column(name = "update")
    private LocalDateTime updated;

    @PrePersist
    private void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        updated = LocalDateTime.now();
    }
}
