package com.example.catsproject.controller;

import com.example.catsproject.controller.response.ShelterReturnResponse;
import com.example.catsproject.model.CatShelter;
import com.example.catsproject.controller.request.ShelterRequest;
import com.example.catsproject.service.ShelterService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class ShelterController {
    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    //Create a shelter
    @PostMapping("/shelter")
    public ShelterReturnResponse createShelter(@RequestBody @Valid ShelterRequest shelterRequest) {

        CatShelter newCatShelter = CatShelter
                .builder()
                .name(shelterRequest.getName())
                .location(shelterRequest.getLocation())
                .volunteers(shelterRequest.getVolunteers())
                .build();

        final CatShelter shelter = shelterService.createShelter(newCatShelter);
        return new ShelterReturnResponse(shelter.getId(),shelter.getName(),shelter.getLocation(),shelter.getVolunteers());
    }

    //Delete by ID
    @DeleteMapping("/delete/{id}")
    public void deleteCatShelter(@PathVariable(value = "id") Long catShelterId) {
        shelterService.deleteById(catShelterId);
    }
}
