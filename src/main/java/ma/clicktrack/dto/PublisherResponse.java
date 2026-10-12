package ma.clicktrack.dto;

import ma.clicktrack.model.enums.Categorie;

public class PublisherResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String email;   
    private Categorie categorie;


    public PublisherResponse(Long id, String nom, String prenom, String email, Categorie categorie) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Categorie getCategorie() {
        return categorie;
    }
}
