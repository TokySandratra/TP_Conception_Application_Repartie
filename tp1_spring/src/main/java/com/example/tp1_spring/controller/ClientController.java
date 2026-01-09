package com.example.tp1_spring.controller;

import com.example.tp1_spring.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/gestion")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }
    @PostMapping("/inscription")
    public RedirectView inscriptionClient(@RequestParam String email, @RequestParam String password, @RequestParam String nom, @RequestParam String prenom){
        clientService.addClient(email,password,nom,prenom);
        return new RedirectView("/gestion/home");
    }
}
