package ma.clicktrack.dto;

public class OffreResponse {
    private Long id;
    private String nom;
    private Long clicks;
    

    public OffreResponse(Long id, String nom, Long clicks) {
        this.id = id;
        this.nom = nom;
        
        this.clicks = clicks;
        
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Long getClicks() {
        return clicks;
    }
}
