package ma.clicktrack.model;

public class Lien {

    private Long id;
    private Long publisherId;
    private String urlDestination;
    private Long clicks;
    private String offre;

    public Lien(Long id,Long publisherId , String urlDestination, Long clicks, String offre){
        this.id = id;
        this.publisherId = publisherId;
        this.urlDestination = urlDestination;
        this.clicks = clicks;
        this.offre = offre;
    }

    public Lien() {
    }

    public synchronized void incrementClicks() {
        this.clicks++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public String getUrlDestination() {
        return urlDestination;
    }

    public void setUrlDestination(String urlDestination) {
        this.urlDestination = urlDestination;
    }

    public Long getClicks() {
        return clicks;
    }

    public Long getPublisherId() {
        return publisherId;
    }



    
}