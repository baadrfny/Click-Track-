package ma.clicktrack.repository.impl;

import java.util.ArrayList;
import java.util.List;

import ma.clicktrack.model.Lien;
import ma.clicktrack.repository.LienRepository;

public class LienRepositoryImpl implements LienRepository{


    private List<Lien> liens = new ArrayList<>();

    @Override 
    public List<Lien> findByPublisherId(Long publisherId){
        List<Lien> linkPublisherId = new ArrayList<>();
        for (int i = 0; i < liens.size(); i++) {
            Lien lien = liens.get(i);
            if (lien.getPublisherId().equals(publisherId)) {
                linkPublisherId.add(lien);
            }
        }
        return linkPublisherId;
    }


    @Override 
    public Lien findById(Long id){
        for (int i = 0; i < liens.size(); i++) {
            Lien lien = liens.get(i);
            if (lien.getId().equals(id)) {
                return lien;
            }
        }
        return null;
    }

    @Override 
    public void save(Lien lien){
        liens.add(lien);
    }
}