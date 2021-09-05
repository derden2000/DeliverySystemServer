package ru.antonshu.couriersystem.services;

import org.springframework.stereotype.Service;
import ru.antonshu.couriersystem.entities.Wallet;

import java.math.BigDecimal;

@Service
public interface WalletService {

    Wallet findByClientId(Long clientId);

    BigDecimal getBalanceByClientId(Long clientId);
}
