package Commande_Microservice.dto;

public class Produit {

    private Integer idProduit;
    private String description;
    private double prix;

    public Integer getIdProduit() { return idProduit; }
    public void setIdProduit(Integer idProduit) { this.idProduit = idProduit; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrix () { return prix; }
    public void setPrix (double prix) { this.prix = prix; }
}
