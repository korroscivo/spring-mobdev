package com.mobdev.backend.service;

import com.mobdev.backend.model.Breed;
import com.mobdev.backend.repository.BreedRepository;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BreedService {
    @Autowired
    private BreedRepository breedRepository;

    public List<Breed> getAll() throws IOException, JSONException{
        JSONObject obj = breedRepository.getJsonByURL("https://dog.ceo/api/breeds/list/all");
        JSONObject jsonObjBreeds = (JSONObject) obj.get("message");
        List<Breed> listBreeds = new ArrayList<>();
        Iterator<String> it = jsonObjBreeds.keys();
        while(it.hasNext()) {
            String key = it.next();
            Breed breed = new Breed(key);

            JSONArray listSubBreedsObj = (JSONArray) jsonObjBreeds.get(key);
            List<Breed> listSubBreeds = new ArrayList<>();
            for (int i = 0; i < listSubBreedsObj.length(); i++) {
                Breed subBreed = new Breed(listSubBreedsObj.get(i).toString());
                listSubBreeds.add(subBreed);
            }
            breed.setSubBreed(listSubBreeds);
            listBreeds.add(breed);
        }
        //System.out.println(json.get("id"));
        return listBreeds;
    }

    public List<String> getImagesByBreed(String breed) throws IOException, JSONException{
        breed = breed.replace("-", "/");
        JSONObject jsonObjImages = (JSONObject) breedRepository.getJsonByURL("https://dog.ceo/api/breed/"+breed+"/images");
        JSONArray listImagesObj = (JSONArray) jsonObjImages.get("message");
        List<String> listImages = new ArrayList<>();
        for (int i = 0; i < listImagesObj.length(); i++) {
            listImages.add(listImagesObj.get(i).toString());
        }
        System.out.println(listImages);
        return listImages;
    }

}
