package ma.clicktrack.model;

public class Lien {

    private Long id;
    private String offre;
    private String urlDestination;
    private Long clicks;
    private Long publisherId;

    public Lien(Long id,String offre, String urlDestination, Long clicks, Long publisherId){
        this.id = id;
        this.offre = offre;
        this.urlDestination = urlDestination;
        this.clicks = clicks;
        this.publisherId = publisherId;
    }

    public Long getId() {
        return id;
    }

    public String getOffre() {
        return offre;
    }

    public String getUrlDestination() {
        return urlDestination;
    }

    public Long getClicks() {
        return clicks;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    
}