package com.example.groupe2.readflex.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Story")
@AllArgsConstructor
@NoArgsConstructor
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name= "storyName")
    private String storyName;

    @Column(name= "storyDescription")
    private String storyDescription;

    @Column(name= "storyImage")
    private String storyImage;

    @Column(name = "storyContent")
    private String storyContent;

}
