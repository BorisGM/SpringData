package com.example.musicdb.model.view;

import com.example.musicdb.model.entity.enums.ArtistEnum;
import com.example.musicdb.model.entity.enums.GenreEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
    private Long id;
    private String name;
    private ArtistEnum artist;
    private GenreEnum genreEnum;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String imageUrl;
    private Integer copies;

    public AlbumViewModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public ArtistEnum getArtist() {
        return artist;
    }

    public AlbumViewModel setArtist(ArtistEnum artist) {
        this.artist = artist;
        return this;
    }

    public GenreEnum getGenreEnum() {
        return genreEnum;
    }

    public AlbumViewModel setGenreEnum(GenreEnum genreEnum) {
        this.genreEnum = genreEnum;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumViewModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumViewModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }
}
