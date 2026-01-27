package com.example.tp1_spring.controller;

import com.example.tp1_spring.data.Client;
import com.example.tp1_spring.service.ClientService;
import jakarta.servlet.http.HttpSession;
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
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    // ------ INSCRIPTION ---------

    @GetMapping("/inscription")
    public ModelAndView inscription(){
        return new ModelAndView("inscription");
    }

    @PostMapping("/inscription")
    public RedirectView inscriptionClient(@RequestParam String email, @RequestParam String password, @RequestParam String nom, @RequestParam String prenom){
        clientService.addClient(email,password,nom,prenom);
        return new RedirectView("/gestion/home");
    }

    // ------------- CONNEXION ---------------

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView authentification(@RequestParam String email, @RequestParam String password, HttpSession session){
        Client client = clientService.connexionClient(email,password);
        if(client == null){
            ModelAndView mv = new ModelAndView("login");
            mv.addObject("error","Email ou mot de passe incorrect");
            return mv;
        }
        session.setAttribute("clientEmail", client.getEmail());
        return new ModelAndView(new RedirectView("/gestion/commandes"));

    }

    //----- LOG OUT ________
    @GetMapping("/logout")
    public RedirectView logout(HttpSession session) {
        session.invalidate();
        return new RedirectView("/gestion/home");
    }
}
