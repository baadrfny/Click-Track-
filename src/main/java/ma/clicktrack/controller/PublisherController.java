
package ma.clicktrack.controller;

import java.util.List;

import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;
import ma.clicktrack.service.impl.LienServiceImpl;
import ma.clicktrack.service.impl.PublisherServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    private final PublisherServiceImpl publisherServiceImpl;
    private final LienServiceImpl lienServiceImpl;

    public PublisherController(
            PublisherServiceImpl publisherServiceImpl,
            LienServiceImpl lienServiceImpl) {

        this.publisherServiceImpl = publisherServiceImpl;
        this.lienServiceImpl = lienServiceImpl;
    }

    @GetMapping("/api/publishers")
    public ResponseEntity<List<Publisher>> getPublishers() {
        return ResponseEntity.ok(
                publisherServiceImpl.getAllPublishers()
        );
    }

    @GetMapping("/api/publishers/{id}")
    public ResponseEntity<?> getPublisherById(
            @PathVariable("id") Long id) {

        Publisher publisher = publisherServiceImpl.getPublisherById(id);

        if (publisher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publisher not found");
        }

        return ResponseEntity.ok(publisher);
    }

    @GetMapping("/api/publishers/{id}/offres")
    public ResponseEntity<?> getPublisherOffres(
            @PathVariable("id") Long id) {

        Publisher publisher = publisherServiceImpl.getPublisherById(id);

        if (publisher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publisher not found");
        }

        return ResponseEntity.ok(
                publisherServiceImpl.getPublisherOffres(id)
        );
    }

    @GetMapping("/api/publishers/{id}/liens")
    public ResponseEntity<?> getPublisherLiens(
            @PathVariable("id") Long id) {

        Publisher publisher = publisherServiceImpl.getPublisherById(id);

        if (publisher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publisher not found");
        }

        return ResponseEntity.ok(
                lienServiceImpl.getPublisherLiens(id)
        );
    }

    @PostMapping("/api/publishers/{id}/liens")
    public ResponseEntity<?> createLien(
            @PathVariable("id") Long publisherId,
            @RequestBody Lien lien) {

        // Check whether the publisher exists
        Publisher publisher =
                publisherServiceImpl.getPublisherById(publisherId);

        if (publisher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publisher not found");
        }

        // Validate the required fields
        if (lien.getUrlDestination() == null
                || lien.getUrlDestination().isBlank()
                || lien.getOffre() == null
                || lien.getOffre().isBlank()) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("urlDestination and offre are required");
        }

        // Create the link
        Lien createdLien = lienServiceImpl.createLink(
                publisherId,
                lien.getUrlDestination(),
                lien.getOffre()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdLien);
    }
}
