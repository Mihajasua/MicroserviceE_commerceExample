1- Lancer les 3 microservices dans IntellIj (Sur chaque mainApplication.java clique sur "run"
2- Ajout de données, dans windows Powershell, entrez les commandes suivantes
    Ajouter client  :   Invoke-RestMethod -Uri http://localhost:8082/clients-Method POST-Body '{"nomClient":"Alice"}'-ContentType 'application/json'
    Ajouter produit : Invoke-RestMethod -Uri http://localhost:8081/produits-Method POST-Body '{"description":"ordinateur,"prix": 1200}'-ContentType 'application/json'
    Ajouter commande : Invoke-RestMethod -Uri http://localhost:8083/commandes-Method POST-Body '{"idProduit":1,"idClient":1,"quantite":4}' -ContentType 'application/json'
3- Pour verifier dans la base de données 
    Base de données client : http://localhost:8082/h2-console
    Base de données produit : http://localhost:8081/h2-console
    Base de données commande : http://localhost:8083/h2-console
    
