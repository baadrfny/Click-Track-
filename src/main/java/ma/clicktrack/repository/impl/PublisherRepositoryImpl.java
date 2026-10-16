package ma.clicktrack.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import ma.clicktrack.model.Publisher;
import ma.clicktrack.model.enums.Categorie;
import ma.clicktrack.repository.PublisherRepository;

public  class PublisherRepositoryImpl implements PublisherRepository {
    

    private final List<Publisher> publishers = new ArrayList<>(List.of(
    new Publisher(1L, "Badr", "Fenni", "badr@example.com", Categorie.TECHNOLOGIE),
    new Publisher(2L, "Yassine", "Amrani", "yassine@example.com", Categorie.SPORT),
    new Publisher(3L, "Sara", "Alaoui", "sara@example.com", Categorie.POLITIQUE),
    new Publisher(4L, "Omar", "Idrissi", "omar@example.com", Categorie.ECONOMIE)
));



    @Override
    public synchronized List<Publisher> findAll(){
        return new ArrayList<>(publishers);
    }


    @Override
    public synchronized Publisher findById(Long id) {
        return publishers.stream().filter(publisher -> Objects.equals(publisher.getId(),id))
                            .findFirst().orElse(null);
    }

    @Override 
    public synchronized void save(Publisher publisher){
        publishers.add(publisher);
    }
}