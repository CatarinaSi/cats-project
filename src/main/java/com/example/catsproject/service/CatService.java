package com.example.catsproject.service;


import com.example.catsproject.controller.request.CatRequest;
import com.example.catsproject.exception.CatNotFound;
import com.example.catsproject.model.Cat;
import com.example.catsproject.model.CatBreed;
import com.example.catsproject.repository.CatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class CatService {

    private final CatRepository catRepository;

    private final FeedService feedService;

    public CatService(CatRepository catRepository, FeedService feedService) {
        this.catRepository = catRepository;
        this.feedService = feedService;
    }

    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    public Cat addCat(Cat newcat) {
        return catRepository.save(newcat);
    }

    // Checks if an Cat exists in the database
    private boolean checkIfCatIsOnShelter(Cat cat) {
        if (cat.getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cat not found in the shelter.");
        }
        return this.catRepository.existsById(cat.getId());
    }
    public List<Cat> findByBreed(String breed) {
        return catRepository.findByBreed((CatBreed.valueOf(breed)));
    }
    public Cat updateCat(Cat newcat, String id) {
       Cat cat = this.updateCat(newcat,id);
        cat.setName(newcat.getName());
        cat.setAge(newcat.getAge());
        cat.setBreed(newcat.getBreed());
        return catRepository.save(cat);
    }
}






   


