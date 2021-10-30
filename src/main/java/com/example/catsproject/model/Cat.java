package com.example.catsproject.model;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Cats")
@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private CatBreed breed;

     @ManyToOne
    private CatShelter catShelter;


    @ManyToMany
    @JoinTable(name = "cats_feed",
            joinColumns = @JoinColumn(name = "cats_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "feed_id", referencedColumnName = "id"))
    private List<Feed> feedList;


    }







