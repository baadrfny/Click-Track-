package ma.clicktrack.repository;


import java.util.List;

import ma.clicktrack.model.Lien;

public interface LienRepository {

    List<Lien> findByPublisherId(Long publisherId);
    Lien findById(Long id);
    void save(Lien lien);
}