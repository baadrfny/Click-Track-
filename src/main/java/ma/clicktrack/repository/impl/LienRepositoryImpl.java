package ma.clicktrack.repository.impl;

import java.util.ArrayList;
import java.util.List;

import ma.clicktrack.model.Lien;
import ma.clicktrack.repository.LienRepository;

public class LienRepositoryImpl implements LienRepository {

    private final List<Lien> liens = new ArrayList<>(List.of(
            new Lien(1L, 1L, "https://example.com/laptop", 25L, "Gaming Laptop"),
            new Lien(2L, 1L, "https://example.com/phone", 12L, "Smartphone"),
            new Lien(3L, 2L, "https://example.com/shoes", 40L, "Football Shoes"),
            new Lien(4L, 2L, "https://example.com/watch", 18L, "Sports Watch"),
            new Lien(5L, 3L, "https://example.com/news", 30L, "News Subscription"),
            new Lien(6L, 4L, "https://example.com/report", 10L, "Economic Report"),
            new Lien(7L, 1L, "https://example.com/mouse", 15L, "Gaming Mouse"),
            new Lien(8L, 2L, "https://example.com/running", 22L, "Running Shoes")));

    private Long idCounter = 8L;

    @Override
    public List<Lien> findByPublisherId(Long publisherId) {
        return liens.stream()
                .filter(lien -> lien.getPublisherId().equals(publisherId))
                .toList();
    }

    @Override
    public synchronized Lien findById(Long id) {
        for (int i = 0; i < liens.size(); i++) {
            Lien lien = liens.get(i);
            if (lien.getId().equals(id)) {
                return lien;
            }
        }
        return null;
    }

    @Override
    public synchronized void save(Lien lien) {
        idCounter++;
        lien.setId(idCounter);
        liens.add(lien);
    }
}