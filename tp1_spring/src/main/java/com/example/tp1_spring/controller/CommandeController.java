package com.example.tp1_spring.controller;

import com.example.tp1_spring.data.Commande;
import com.example.tp1_spring.service.CommandeService;
import com.example.tp1_spring.service.LigneCommandeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

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
            return new ModelAndView(new RedirectView("login"));
        }

        List<Commande> commandes = commandeService.getCommandesClient(clientEmail);
        ModelAndView mv = new ModelAndView("commande");
        mv.addObject("commandes",commandes);
        mv.addObject("clientEmail", clientEmail);
        return mv;
    }

    @PostMapping("/commandes/creer")
    public ModelAndView creerCommande(HttpSession session, @RequestParam String name){
        String clientEmail =(String) session.getAttribute("clientEmail");
        if (clientEmail == null){
            return new ModelAndView(new RedirectView("/gestion/commandes"));
        }
        Commande commande = commandeService.enregistrerCommande(name,clientEmail);
        commandeService.ajouterLigne(commande.getId(), "", 0, 0.0);
        ModelAndView mv = new ModelAndView(new RedirectView("/gestion/commandes/"+commande.getId()));
        mv.addObject("message","commande créée : "+commande.getId());
        return mv;
    }

    @GetMapping("/commandes/{id}")
    public ModelAndView commandeDetails(@PathVariable("id") Long id, HttpSession session) {
        String clientEmail = (String) session.getAttribute("clientEmail");
        if (clientEmail == null) return new ModelAndView(new RedirectView("/gestion/login", true));


        Commande commande = commandeService.getById(id);

        ModelAndView mv = new ModelAndView("commande-details");
        mv.addObject("commande", commande);
        mv.addObject("clientEmail", clientEmail);
        return mv;
    }

    @PostMapping("/commandes/{id}/ajouter-ligne")
    public ModelAndView addLinecommand(@PathVariable("id") Long commandeId,@RequestParam String labelProduct, @RequestParam int quantity, @RequestParam double priceUnit){
        commandeService.ajouterLigne(commandeId,labelProduct,quantity,priceUnit);
        return new ModelAndView(new RedirectView("/gestion/commandes/"+commandeId));
    }

    @PostMapping("/commandes/{commandeId}/supprimer-ligne/{ligneId}")
    public ModelAndView supprimerLigne(@PathVariable("commandeId")Long commandeId, @PathVariable("ligneId") Long ligneId){
        commandeService.supprimmerLigne(ligneId);
        return new ModelAndView(new RedirectView("/gestion/commandes/"+commandeId));
    }
}
