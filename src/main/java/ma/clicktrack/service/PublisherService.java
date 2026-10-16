package ma.clicktrack.service;

import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;
import java.util.List;

public interface PublisherService {

    List<Publisher> getAllPublishers();
    Publisher getPublisherById(Long id);
    List<String> getPublisherOffres(Long publisherId);
}