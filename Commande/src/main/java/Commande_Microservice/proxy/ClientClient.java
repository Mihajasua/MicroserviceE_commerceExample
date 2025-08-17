package Commande_Microservice.proxy;

import Commande_Microservice.dto.Client;
import org.springframework.web.client.RestTemplate;

public class ClientClient {
    private final RestTemplate restTemplate;

    public ClientClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Commande_Microservice.dto.Client getCustomerById(Integer idClient) {
        return restTemplate.getForObject("http://localhost:8082/clients/" + idClient, Client.class);
    }
}
