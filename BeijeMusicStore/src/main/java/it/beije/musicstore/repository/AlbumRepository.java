package it.beije.musicstore.repository;


import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Canzone;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    @Query(nativeQuery = true,value="SELECT * FROM Album  WHERE titolo=:nomeAlbum")
    public Album findByAlbum(@Param("nomeAlbum")String nomeAlbum);
}
