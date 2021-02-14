package pro.antonshu.couriersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.antonshu.couriersystem.services.tokens.PasswordResetToken;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {


    PasswordResetToken findByToken(String token);
}
