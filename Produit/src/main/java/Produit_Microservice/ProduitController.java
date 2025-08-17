package Produit_Microservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {
    private final ProduitRepository repository;

    public ProduitController(ProduitRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Produit> all() {
        return repository.findAll();
    }

    @GetMapping("/{idProduit}")
    public Produit one(@PathVariable Integer idProduit) {
        return repository.findById(idProduit).orElseThrow();
    }

    @PostMapping
    public Produit newProduct(@RequestBody Produit produit) {
        return repository.save(produit);
    }
}
