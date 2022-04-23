package com.example.musicdb.service.impl;

import com.example.musicdb.model.entity.AlbumEntity;
import com.example.musicdb.model.service.AlbumServiceModel;
import com.example.musicdb.model.view.AlbumViewModel;
import com.example.musicdb.repository.AlbumRepository;
import com.example.musicdb.service.AlbumService;
import com.example.musicdb.service.ArtistService;
import com.example.musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistService artistService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistService artistService, UserService userService, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(AlbumServiceModel albumServiceModel, Long id) {
        AlbumEntity album = modelMapper.map(albumServiceModel, AlbumEntity.class);

        album.setArtist(artistService.findByName(albumServiceModel.getArtist()))
                .setReleasedDate(albumServiceModel.getReleaseDate())
                .setAddedFrom(userService.findById(id));

        albumRepository.save(album);
    }

    @Override
    public List<AlbumViewModel> getAllAlbums() {
        return albumRepository
                .getAlbumsByOrder()
                .stream()
                .map(albumEntity -> {
                    AlbumViewModel albumViewModel = new AlbumViewModel();
                    modelMapper.map(albumEntity, AlbumViewModel.class);
                    albumViewModel
                            .setId(albumEntity.getId())
                            .setName(albumEntity.getName())
                            .setArtist(albumEntity.getArtist().getName())
                            .setGenreEnum(albumEntity.getGenre())
                            .setPrice(albumEntity.getPrice())
                            .setReleasedDate(albumEntity.getReleasedDate())
                            .setCopies(albumEntity.getCopies())
                            .setImageUrl(String.format("/img/%s.jpg", albumEntity.getArtist().getName()));

                    return albumViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getTotalCopies() {
        if (albumRepository.count() == 0) {
            return BigDecimal.valueOf(0);
        }
        return albumRepository.findTotalCopies();

    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}
