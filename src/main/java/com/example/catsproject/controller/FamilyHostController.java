package com.example.catsproject.controller;


import com.example.catsproject.controller.request.CatRequest;
import com.example.catsproject.controller.response.CatReturnResponse;
import com.example.catsproject.exception.CatException;
import com.example.catsproject.model.Cat;
import com.example.catsproject.service.CatService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class FamilyHostController {

    private CatService catService;

    public FamilyHostController(CatService catService) {
        this.catService = catService;
    }

    //Read All
    @GetMapping(value = "/cats")
    public List<Cat> getCats() {
        return catService.findAll();
    }

    //Create a new cat
    @PostMapping(value = "/cat", consumes = "application/json")
    public List<CatReturnResponse> addCat(@RequestBody @Valid CatRequest catRequest) {
        final List<Cat> catList = catService.findAll();
        List<CatReturnResponse> catReturnResponseList = new ArrayList<CatReturnResponse>();
        for (Cat cat : catList)
            catReturnResponseList.add(new CatReturnResponse(cat.getId(), cat.getName(), cat.getAge(), cat.getBreed()));
        return catReturnResponseList;
    }

    @GetMapping("/cats/{breed}")
    public List<CatReturnResponse> getCatByBreed(@PathVariable(value = "breed") String breed) {
        List<Cat> catList = catService.findByBreed(breed);
        List<CatReturnResponse> catReturnResponseList = new ArrayList<>();
        for (Cat cat : catList) {
            catReturnResponseList.add(new CatReturnResponse(cat.getId(), cat.getName(), cat.getAge(), cat.getBreed()));
        }
        return catReturnResponseList;
    }

    @PutMapping("/cats/{id}")
    public CatReturnResponse updateCat(@RequestBody @Valid CatRequest catRequest, @PathVariable(value = "id") String id) {
        Cat cat = catService.updateCat(Cat.builder()
                .name(catRequest.getName())
                .age(catRequest.getAge())
                .breed(catRequest.getCatBreed())
                .build(), id
        );
        return new CatReturnResponse(
                cat.getId(),
                cat.getName(),
                cat.getAge(),
                cat.getBreed()
        );
    }
}








