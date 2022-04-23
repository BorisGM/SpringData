package com.example.musicdb.model.binding;

import com.example.musicdb.model.entity.enums.ArtistEnum;
import com.example.musicdb.model.entity.enums.GenreEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer copies;
    private LocalDate releaseDate;
    private String producer;
    private ArtistEnum artist;
    private GenreEnum genre;
    private String description;

    public AlbumAddBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    @NotBlank(message = "Name cannot be empty!")
    public String getName() {
        return name;
    }

    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 5, message = "Image url must be minimum than 5 characters!")
    @NotBlank(message = "Image url cannot be empty!")
    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @NotNull(message = "Price cannot be empty!")
    @DecimalMin(value = "0", message = "Price must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull(message = "Copies cannot be empty!")
    @Min(value = 10, message = "Copies must be minimum 10")
    public Integer getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    @NotNull(message = "Release date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Release date cannot be in the future!")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumAddBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @NotNull(message = "You must select a artist!")
    public ArtistEnum getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(ArtistEnum artist) {
        this.artist = artist;
        return this;
    }

    @NotNull(message = "You must select a genre!")
    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    @Size(min = 5, message = "Description must be minimun 5 characters long!")
    @NotBlank(message = "Description cannot be empty!")
    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
