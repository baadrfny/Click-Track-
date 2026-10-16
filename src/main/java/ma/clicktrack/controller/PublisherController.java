
package ma.clicktrack.controller;

import java.util.List;

import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;
import ma.clicktrack.service.LienService;
import ma.clicktrack.service.PublisherService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    private final PublisherService publisherService;
    private final LienService lienService;

    public PublisherController(
            PublisherService publisherService,
            LienService lienService) {

        this.publisherService = publisherService;
        this.lienService = lienService;
    }

    @GetMapping("/api/publishers")
    public ResponseEntity<List<Publisher>> getPublishers() {
        return ResponseEntity.ok(
                publisherService.getAllPublishers()
        );
    }

    @GetMapping("/api/publishers/{id}")
    public ResponseEntity<?> getPublisherById(
            @PathVariable("id") Long id) {

        Publisher publisher = publisherService.getPublisherById(id);

        if (publisher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publisher not found");
        }

        return ResponseEntity.ok(publisher);
    }

    @GetMapping("/api/publishers/{id}/offres")
    public ResponseEntity<?> getPublisherOffres(
            @PathVariable("id") Long id) {

        Publisher publisher = publisherService.getPublisherById(id);

        if (publisher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publisher not found");
        }

        return ResponseEntity.ok(
                publisherService.getPublisherOffres(id)
        );
    }

    @GetMapping("/api/publishers/{id}/liens")
    public ResponseEntity<?> getPublisherLiens(
            @PathVariable("id") Long id) {

        Publisher publisher = publisherService.getPublisherById(id);

        if (publisher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publisher not found");
        }

        return ResponseEntity.ok(
                lienService.getPublisherLiens(id)
        );
    }

    @PostMapping("/api/publishers/{id}/liens")
    public ResponseEntity<?> createLien(@PathVariable("id") Long publisherId, @RequestBody Lien lien) {

        Publisher publisher = publisherService.getPublisherById(publisherId);

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
        Lien createdLien = lienService.createLink(
                publisherId,
                lien.getUrlDestination(),
                lien.getOffre()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdLien);
    }
}
