package ru.antonshu.couriersystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.antonshu.couriersystem.entities.Client;
import ru.antonshu.couriersystem.services.ClientService;

import java.security.Principal;
import java.text.NumberFormat;

@Controller
public class OrderController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/orders")
    public String ordersPage(Model model, Principal principal) {
        Client user = clientService.findByPhone(principal.getName());
        model.addAttribute("user", user);
        NumberFormat rubles = NumberFormat.getCurrencyInstance();
        model.addAttribute("balance", rubles.format(user.getWallet().getBalance().doubleValue()));
        return "order";
    }
}
