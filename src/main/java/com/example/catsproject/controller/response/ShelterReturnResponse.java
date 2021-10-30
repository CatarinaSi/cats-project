package com.example.catsproject.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShelterReturnResponse {
    private Long Id;
    private String name;
    private String location;
    private int volunteers;

}
