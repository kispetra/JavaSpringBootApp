package com.example.task1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter @Setter
@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_sequence")
    @SequenceGenerator(name = "car_sequence", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="client_id")
    private Client client;
    @Enumerated
    @Column(name="cartype")
    private CarType carType;
    @Column
    private Integer year;
    @Column(name="registrationmark")
    private String registrationMark;
    @Column
    private String color;

}
