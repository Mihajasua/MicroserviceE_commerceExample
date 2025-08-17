package Commande_Microservice;

import Commande_Microservice.proxy.ClientClient;
import Commande_Microservice.proxy.ProductClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ClientClient customerClient(RestTemplate restTemplate) {
        return new ClientClient(restTemplate);
    }

    @Bean
    public ProductClient productClient(RestTemplate restTemplate) {
        return new ProductClient(restTemplate);
    }
}
