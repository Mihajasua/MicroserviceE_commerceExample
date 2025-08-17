package Commande_Microservice.proxy;

import Commande_Microservice.dto.Produit;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductClient {
    private final RestTemplate restTemplate;

    public ProductClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Commande_Microservice.dto.Produit getProductById(Integer idProduit) {
        return restTemplate.getForObject("http://localhost:8081/produits/" + idProduit, Produit.class);
    }
}
