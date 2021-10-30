package com.example.catsproject.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShelterRequest {
    private Long Id;
    private String name;
    private String location;
    private int volunteers;
}
