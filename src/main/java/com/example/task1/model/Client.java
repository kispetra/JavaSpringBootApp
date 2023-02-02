package com.example.task1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")

@Getter @Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sequence")
    @SequenceGenerator(name = "client_sequence", allocationSize = 1)
    private Long id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column
    private String oib;
    @Column
    private String city;
    @Column
    private String street;
    @Column(name="zipcode")
    private int zipCode;
    @Column
    private String country;
    @Column
    private String adressNumber;
    @Column
    @OneToMany
    private List<Car> cars;

}
