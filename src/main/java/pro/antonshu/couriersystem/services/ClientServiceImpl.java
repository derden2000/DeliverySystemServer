package pro.antonshu.couriersystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pro.antonshu.couriersystem.entities.Client;
import pro.antonshu.couriersystem.entities.Role;
import pro.antonshu.couriersystem.repositories.ClientRepository;
import pro.antonshu.couriersystem.repositories.PasswordTokenRepository;
import pro.antonshu.couriersystem.services.tokens.PasswordResetToken;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private PasswordTokenRepository passwordTokenRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setPasswordTokenRepository(PasswordTokenRepository passwordTokenRepository) {
        this.passwordTokenRepository = passwordTokenRepository;
    }

    @Override
    public Client findByPhone(String phone) {
        return clientRepository.findOneByPhone(phone);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findOneById(id);
    }

    @Override
    public boolean isUserExist(String phone) {
        return clientRepository.existsByPhone(phone);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client regNewUser(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void createPasswordResetTokenForUser(Client client, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, client);
        passwordTokenRepository.save(myToken);
    }

    @Override
    public void changeUserPassword(Client client, String newPassword) {

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Client client = clientRepository.findOneByPhone(userName);
        if (client == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new User(client.getPhone(), client.getPassword(), mapRolesToAuthorities(client.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
        return Collections.singleton(new SimpleGrantedAuthority(role.getTitle()));
    }
}
