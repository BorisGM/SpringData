package com.example.musicdb.model.entity;

import com.example.musicdb.model.entity.enums.ArtistEnum;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity{
    private ArtistEnum name;
    private String careerInformation;

    public ArtistEntity() {
    }

    public ArtistEntity(ArtistEnum name, String careerInformation) {
        this.name = name;
        this.careerInformation = careerInformation;
    }

    @Enumerated(EnumType.STRING)
    public ArtistEnum getName() {
        return name;
    }

    public ArtistEntity setName(ArtistEnum name) {
        this.name = name;
        return this;
    }

    @Column(name = "career_information", columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public ArtistEntity setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}
