package ma.clicktrack.controller;

import ma.clicktrack.service.impl.LienServiceImpl;
import ma.clicktrack.service.impl.PublisherServiceImpl;

import java.util.List;

import ma.clicktrack.model.Lien;
import ma.clicktrack.model.Publisher;

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

    public PublisherController(PublisherServiceImpl publisherServiceImpl , LienServiceImpl lienServiceImpl) {
        this.publisherServiceImpl = publisherServiceImpl;
        this.lienServiceImpl = lienServiceImpl;
    }

    @GetMapping("/api/publishers")
    public List<Publisher> getPublishers() {
        return publisherServiceImpl.getAllPublishers();
    }

    @GetMapping("/api/publishers/{id}")
    public Object getPublisherById(@PathVariable("id") Long id) {
        Publisher publisher = publisherServiceImpl.getPublisherById(id);
        if (publisher == null) {
            return new ResponseEntity<>("Publisher not found", HttpStatus.NOT_FOUND);
        }
        return publisher;
    }

    @GetMapping("/api/publishers/{id}/offres")
    public Object getPublisherOffres(@PathVariable("id") Long id) {
        Publisher publisher = publisherServiceImpl.getPublisherById(id);

        if (publisher == null) {
            return new ResponseEntity<>(
                    "Publisher not found",
                    HttpStatus.NOT_FOUND);
        }

        return publisherServiceImpl.getPublisherOffres(id);
    }



    @GetMapping("/api/publishers/{id}/liens")
    public List<Lien> getPublisherLiens(@PathVariable("id") Long id){
        return lienServiceImpl.getPublisherLiens(id);
    }


    @PostMapping("/api/publishers/{id}/liens")
    public Lien createLien(@PathVariable("id") Long puhlisherId , @RequestBody Lien lien){
        return lienServiceImpl.createLink(puhlisherId , lien.getUrlDestination() , lien.getOffre());
    }


    

}