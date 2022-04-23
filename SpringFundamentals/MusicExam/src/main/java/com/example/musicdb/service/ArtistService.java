package com.example.musicdb.service;

import com.example.musicdb.model.entity.ArtistEntity;
import com.example.musicdb.model.entity.enums.ArtistEnum;

public interface ArtistService {
    void initArtists();

    ArtistEntity findByName(ArtistEnum artistEnum);
}
