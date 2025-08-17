package Commande_Microservice.repository;

import Commande_Microservice.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRespository extends JpaRepository<Commande, Integer> {
}
