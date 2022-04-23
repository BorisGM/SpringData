package com.example.musicdb.model.entity;

import com.example.musicdb.model.entity.enums.GenreEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class AlbumEntity extends BaseEntity{

    private String name;
    private String imageUrl;
    private String description;
    private Integer copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private GenreEnum genre;
    private ArtistEntity artist;
    private UserEntity addedFrom;

    public AlbumEntity() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public AlbumEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public AlbumEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "copies")
    public Integer getCopies() {
        return copies;
    }

    public AlbumEntity setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "released_date")
    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumEntity setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    @Column(name = "producer")
    public String getProducer() {
        return producer;
    }

    public AlbumEntity setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumEntity setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    @ManyToOne
    public ArtistEntity getArtist() {
        return artist;
    }

    public AlbumEntity setArtist(ArtistEntity artist) {
        this.artist = artist;
        return this;
    }

    @ManyToOne
    public UserEntity getAddedFrom() {
        return addedFrom;
    }

    public AlbumEntity setAddedFrom(UserEntity addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}
