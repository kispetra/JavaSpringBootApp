package com.example.task1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter@Setter
@Table(name="carservice")
@Entity
public class CarService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carservice_sequence")
    @SequenceGenerator(name = "carservice_sequence", allocationSize = 1)
    private Long id;
    @JoinColumn(name="carid")
    @JsonBackReference
    @ManyToOne
    private Car car;
    @Column(name="dateofservice")
    private LocalDateTime dateOfService;
    @Column(name="workerfirstname")
    private String workerFirstName;
    @Column(name="workerlastname")
    private String workerLastName;
    @Column(name="workdescription")
    private String workDescription;
    @Column(name="price")
    private Float price;
    @Column(name="ispaid")
    private Boolean isPaid;
}
