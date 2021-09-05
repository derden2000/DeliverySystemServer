package ru.antonshu.couriersystem.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer extends Client {

    @OneToMany(mappedBy = "owner")
    private List<Order> orders;

}
