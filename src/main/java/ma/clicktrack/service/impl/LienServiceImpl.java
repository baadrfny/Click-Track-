package ma.clicktrack.service.impl;

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
}