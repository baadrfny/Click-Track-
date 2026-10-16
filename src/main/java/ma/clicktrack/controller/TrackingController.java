package ma.clicktrack.controller;

import ma.clicktrack.service.LienService;


import ma.clicktrack.model.Lien;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TrackingController {

    private final LienService lienService;

    public TrackingController(LienService lienService){
        this.lienService = lienService;
    }

    @GetMapping("/api/t/{id}")
    public ResponseEntity<?> trackLink(@PathVariable("id") Long id){

        Lien lien = lienService.trackClick(id);
        if (lien == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Link not found");
        }
        return ResponseEntity.ok(lien);
    }
    
}