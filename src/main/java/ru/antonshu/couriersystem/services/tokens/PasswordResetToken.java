package ru.antonshu.couriersystem.services.tokens;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.antonshu.couriersystem.entities.Client;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pass_tokens")
public class PasswordResetToken {

    private static final long EXPIRATION = 24 * 3600000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = Client.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "client_id")
    private Client client;

    @Column(name = "expiry_date")
    private Date expiryDate;

    public PasswordResetToken(String token, Client client) {
        this.token = token;
        this.client = client;
        this.expiryDate = new Date(System.currentTimeMillis() + EXPIRATION);
    }
}
