package it.beije.musicstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.model.Song;
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
	
	public List<Song> listSongByGenre(String genre){
		List<Song> songs = songRepository.loadByGenre(genre);	
		if(songs == null || songs.size() < 1) return null;		
		return songs;
	}
	
	public Song getSongByTitle(String title) {
		Song song = songRepository.findByTitle(title);	
		if(song == null) return null;	
		return song;
	}

}
