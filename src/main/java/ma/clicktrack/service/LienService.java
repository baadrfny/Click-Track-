package ma.clicktrack.service;



import java.util.List;

import ma.clicktrack.model.Lien;

public interface LienService {
    Lien trackClick(Long id);
    Lien createLink(Long publisherId ,String urlDestination , String offre);
    List<Lien> getPublisherLiens(Long publisherId);

}