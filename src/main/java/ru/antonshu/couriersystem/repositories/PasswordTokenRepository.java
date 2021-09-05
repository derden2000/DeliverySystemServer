package ru.antonshu.couriersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonshu.couriersystem.services.tokens.PasswordResetToken;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {


    PasswordResetToken findByToken(String token);
}
