package com.example.tp1_spring.controller;

import com.example.tp1_spring.data.LigneCommande;
import com.example.tp1_spring.service.CommandeService;
import com.example.tp1_spring.service.LigneCommandeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gestion")
public class CommandeController {
    private final CommandeService commandeService;
    private final LigneCommandeService ligneCommandeService;
    public CommandeController(CommandeService commandeService, LigneCommandeService ligneCommandeService) {
        this.commandeService = commandeService;
        this.ligneCommandeService = ligneCommandeService;
    }


    // ---- Afficher interface commande après connexion validée-----

    @GetMapping("/commandes")
    public ModelAndView commandes(HttpSession session){
        String clientEmail = (String) session.getAttribute("clientEmail");
        if (clientEmail == null ){
            return new ModelAndView("login");
        }
        ModelAndView mv = new ModelAndView("commande");
        mv.addObject("clientEmail", clientEmail);
        //mv.addObject()
        return mv;
    }

    @GetMapping("/nouvelle-commande")
    public ModelAndView nouvel_commande(){
        return new ModelAndView("ajout_commande");
    }

    @PostMapping("/nouvelle-commande")
    public ModelAndView ajoutCommande(@RequestParam String nameCommande, @RequestParam String label, @RequestParam int quantity, @RequestParam double price,HttpSession session){
        return  new ModelAndView("commande");
    }
}
