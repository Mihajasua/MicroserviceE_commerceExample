package Commande_Microservice.controller;

import Commande_Microservice.dto.Client;
import Commande_Microservice.dto.Produit;
import Commande_Microservice.model.Commande;
import Commande_Microservice.proxy.ClientClient;
import Commande_Microservice.proxy.ProductClient;
import Commande_Microservice.repository.CommandeRespository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {
    private final ProductClient productClient;
    private ClientClient clientClient;
    private final CommandeRespository repository;

    public CommandeController(ProductClient productClient, ClientClient clientClient, CommandeRespository repository) {
        this.productClient = productClient;
        this.clientClient = clientClient;
        this.repository = repository;
    }
//    @GetMapping("/test-product/{id}")
//    public String testProduct(@PathVariable Integer idProduit) {
//        Produit p = productClient.getProductById(idProduit);
//        return "Produit trouvé : " + p.getDescription();
//    }


    @PostMapping
    public Commande createOrder(@RequestBody Commande commande) {
        // Vérifie si le produit et le client existent
        Produit p = productClient.getProductById(commande.getIdProduit());
        Client c =  clientClient.getCustomerById(commande.getIdClient());

        if (p == null || c == null) {
            throw new RuntimeException("Client ou produit introuvable");
        }
        return repository.save(commande);
    }

    @GetMapping
    public List<Commande> all() {
        return repository.findAll();
    }

//    @PostMapping
//    public Commande newCommande(@RequestBody Commande commande) {
//        return repository.save(commande);
//    }
}
