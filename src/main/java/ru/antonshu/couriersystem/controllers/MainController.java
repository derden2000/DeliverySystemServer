package ru.antonshu.couriersystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.antonshu.couriersystem.entities.Client;
import ru.antonshu.couriersystem.entities.Role;
import ru.antonshu.couriersystem.entities.Wallet;
import ru.antonshu.couriersystem.repositories.RoleRepository;
import ru.antonshu.couriersystem.repositories.WalletRepository;
import ru.antonshu.couriersystem.services.ClientService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    private ClientService clientService;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private WalletRepository walletRepository;

    @Autowired
    public void setWalletRepository(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    private String getMain() {
        return "main";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registration(Model model) {
        Client user_new = new Client();
        model.addAttribute("client", user_new);
        List<Role> roles = (List<Role>) roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "register";
    }

    @PostMapping("/register")
    public String regNewUser(@ModelAttribute(name = "client") @Valid Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
//        client.setRole(roleRepository.findOneByTitle("ROLE_CUSTOMER"));
        client.setWallet(walletRepository.save(new Wallet()));
        System.out.println(clientService.regNewUser(client));
        return "redirect:/";
    }
}
