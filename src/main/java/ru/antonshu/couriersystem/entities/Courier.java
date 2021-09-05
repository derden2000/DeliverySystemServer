package ru.antonshu.couriersystem.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "couriers")
@Data
@NoArgsConstructor
public class Courier extends Client {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;
}
