package ru.antonshu.couriersystem.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "clients")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private String phone;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
