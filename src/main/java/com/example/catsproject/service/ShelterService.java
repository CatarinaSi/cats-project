package com.example.catsproject.service;

import com.example.catsproject.model.CatShelter;
import com.example.catsproject.repository.CatRepository;
import com.example.catsproject.repository.ShelterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterService {

    private final ShelterRepository shelterRepository;
    private CatRepository catRepository;

    public ShelterService(ShelterRepository shelterRepository, CatRepository CatRepository) {
        this.shelterRepository = shelterRepository;
        this.catRepository = catRepository;
    }

    public CatShelter createShelter(CatShelter newCatShelter) {

        return shelterRepository.save(newCatShelter);
    }

    public void deleteById(Long catShelterId) {

        shelterRepository.deleteById(catShelterId);
    }

    public List<CatShelter> findAll() {

        return shelterRepository.findAll();
    }
}
