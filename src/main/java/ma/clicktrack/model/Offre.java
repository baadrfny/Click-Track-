package ma.clicktrack.model;

public class Offre {

    private Long id;
    private String nom;
    private Long clicks;

    public Offre(Long id, String nom) {
        this.id = id;
        this.nom = nom;
        this.clicks = 0L;
    }

    public Long getId() {
        return id;
    }

    public Long getClicks() {
        return clicks;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
}