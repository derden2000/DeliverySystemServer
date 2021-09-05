package ru.antonshu.couriersystem.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
@Data
//@NoArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private BigDecimal balance;

    public Wallet() {
        this.balance = new BigDecimal(0);
    }
}
