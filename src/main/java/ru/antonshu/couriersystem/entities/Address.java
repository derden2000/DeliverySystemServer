package ru.antonshu.couriersystem.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private Customer owner;
    private String area;
    private String city;
    private String street;
    private String house;

}
