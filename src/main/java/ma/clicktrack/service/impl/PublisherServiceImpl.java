package ma.clicktrack.service.impl;

import java.util.List;

import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;
import ma.clicktrack.repository.LienRepository;
import ma.clicktrack.repository.PublisherRepository;
import ma.clicktrack.service.PublisherService;

public class PublisherServiceImpl implements PublisherService {

    private final LienRepository lienRepository;    
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository, LienRepository lienRepository) {
        this.publisherRepository = publisherRepository;
        this.lienRepository = lienRepository;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id);
    }

    @Override
    public List<String> getPublisherOffres(Long publisherId) {
        return lienRepository.findByPublisherId(publisherId)
                .stream().map(Lien::getOffre)
                .toList();
    }

}