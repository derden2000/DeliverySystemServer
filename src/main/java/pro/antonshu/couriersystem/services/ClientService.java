package pro.antonshu.couriersystem.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import pro.antonshu.couriersystem.entities.Client;

import java.util.List;

public interface ClientService extends UserDetailsService {

    Client findByPhone(String phone);

    Client findById(Long id);

    boolean isUserExist(String phone);

    List<Client> getAllClients();

    Client regNewUser(Client client);

    Client save(Client client);

    void createPasswordResetTokenForUser(Client client, String token);

    void changeUserPassword(Client client, String newPassword);
}
