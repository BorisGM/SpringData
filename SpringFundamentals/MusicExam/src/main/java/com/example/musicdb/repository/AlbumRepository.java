package com.example.musicdb.repository;

import com.example.musicdb.model.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity,Long> {

    @Query("select sum(a.copies) from AlbumEntity as a")
    BigDecimal findTotalCopies();

    @Query("select a from AlbumEntity as a order by a.copies desc ")
    List<AlbumEntity> getAlbumsByOrder();

}
