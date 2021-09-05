package ru.antonshu.couriersystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.antonshu.couriersystem.entities.Client;
import ru.antonshu.couriersystem.services.ClientService;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/profile")
    public String loginPage(Model model, Principal principal) {
        System.out.println("Principal: " + principal.getName());
        Client user = clientService.findByPhone(principal.getName());
        model.addAttribute("user", user);
        return "profile";
    }
}
