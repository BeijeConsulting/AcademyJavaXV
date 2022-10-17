package it.beije.musicstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artist;
import it.beije.musicstore.model.Song;
import it.beije.musicstore.repository.AlbumRepository;
import it.beije.musicstore.repository.ArtistRepository;
import it.beije.musicstore.repository.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepository;
	
	public List<Song> listSongByAlbum(Integer id_album){
		return songRepository.loadByAlbum(id_album);
	}
	
	public List<Song> listSongByArtist(Integer id_artist){
		return songRepository.loadByArtist(id_artist);
	}

}
