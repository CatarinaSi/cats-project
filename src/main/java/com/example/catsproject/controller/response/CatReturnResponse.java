package com.example.catsproject.controller.response;

import com.example.catsproject.model.CatBreed;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class CatReturnResponse {
    private Long id;
    @NotNull
    private String name;
    private int age;
    private CatBreed catBreed;


}
