package ma.clicktrack.repository;

import java.util.List;

import ma.clicktrack.model.Publisher;

public interface PublisherRepository {
    List<Publisher> findAll();
    Publisher findById(Long id);
    void save(Publisher publisher);
}