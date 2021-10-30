package com.example.catsproject.repository;

import com.example.catsproject.model.Cat;
import com.example.catsproject.model.CatBreed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CatRepository extends JpaRepository <Cat,Long> {

    List<Cat> findByBreed(CatBreed valueOf);
}
