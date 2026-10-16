package ma.clicktrack.service.impl;

import java.util.List;

import ma.clicktrack.model.Lien;
import ma.clicktrack.repository.LienRepository;
import ma.clicktrack.service.LienService;

public class LienServiceImpl implements LienService {
    
    private final LienRepository lienRepository;

    public LienServiceImpl(LienRepository lienRepository) {
        this.lienRepository = lienRepository;
    }

    @Override 
    public Lien trackClick(Long id){
        Lien lien = lienRepository.findById(id);

        if (lien == null) {
            return null;
        }

        lien.incrementClicks();
        return lien;
    }

    @Override
    public Lien createLink(Long publisherId ,String urlDestination , String offre){
        Lien lien = new Lien(null, publisherId, urlDestination, 0L, offre);
        lienRepository.save(lien);

        return lien;
    }


    @Override 
    public List<Lien> getPublisherLiens(Long publisherId){
       return lienRepository.findByPublisherId(publisherId);
    }
}