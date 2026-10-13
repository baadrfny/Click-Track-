package ma.clicktrack.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ma.clicktrack.model.Publisher;

import ma.clicktrack.repository.PublisherRepository;

public  class PublisherRepositoryImpl implements PublisherRepository {
    
    private List<Publisher> publishers = new ArrayList<>();


    @Override
    public synchronized List<Publisher> findAll(){
        return new ArrayList<>(publishers);
    }


    @Override 
    public synchronized Publisher findById(Long id){
        for (int i = 0; i < publishers.size(); i++) {
            Publisher publisher = publishers.get(i);
            if (Objects.equals(publisher.getId(), id)) {
                return publisher;
            }
            
        }
        return null;
    }

    @Override 
    public synchronized void save(Publisher publisher){
        publishers.add(publisher);
    }
}