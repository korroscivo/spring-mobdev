package com.mobdev.backend.controller;

import com.mobdev.backend.model.Breed;
import com.mobdev.backend.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/breeds")
public class BreedController {
    @Autowired
    private BreedService breedService;

    @GetMapping("/")
    public ResponseEntity<List<Breed>> getAll() throws IOException {
        List<Breed> listBreeds = new ArrayList<>();
        try {
            return new ResponseEntity<>(breedService.getAll(), HttpStatus.OK);
        } catch (IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<String>> getByBreed(@PathVariable("id") String id) throws IOException {
        try {
            return new ResponseEntity<>(breedService.getImagesByBreed(id), HttpStatus.OK);
        } catch (IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
