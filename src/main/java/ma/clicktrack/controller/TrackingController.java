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
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TrackingController {

    @GetMapping("/api/liens/{id}/track")
    public Lien trackLink(@PathVariable("id") Long id){
        
    }
    
}