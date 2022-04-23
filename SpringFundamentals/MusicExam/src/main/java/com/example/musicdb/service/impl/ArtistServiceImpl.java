package com.example.musicdb.service.impl;

import com.example.musicdb.model.entity.ArtistEntity;
import com.example.musicdb.model.entity.enums.ArtistEnum;
import com.example.musicdb.repository.ArtistRepository;
import com.example.musicdb.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void initArtists() {
        if (artistRepository.count() == 0) {
            Arrays.stream(ArtistEnum.values())
                    .forEach(artistEnum -> {
                        ArtistEntity artist = new ArtistEntity(artistEnum,
                                "Career information: " + artistEnum.name());

                        artistRepository.save(artist);
                    });
        }
    }

    @Override
    public ArtistEntity findByName(ArtistEnum artistEnum) {
        return artistRepository
                .findByName(artistEnum)
                .orElse(null);
    }
}
