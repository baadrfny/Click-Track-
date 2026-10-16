package ma.clicktrack.controller;

import ma.clicktrack.service.impl.LienServiceImpl;


import ma.clicktrack.model.Lien;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TrackingController {

    private final LienServiceImpl lienServiceImpl;

    public TrackingController(LienServiceImpl lienServiceImpl){
        this.lienServiceImpl = lienServiceImpl;
    }

    @GetMapping("/api/liens/{id}/track")
    public Lien trackLink(@PathVariable("id") Long id){
        return lienServiceImpl.trackClick(id);
    }
    
}