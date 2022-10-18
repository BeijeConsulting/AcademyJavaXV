package it.beije.musicstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Song;
import it.beije.musicstore.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private SongService songService;
	
	
	public List<Album> listAlbumByArtist(Integer id_artist){
		return albumRepository.loadByArtist(id_artist);	
	}

	public List<Album> listAllAlbum(){
		return albumRepository.loadAllAlbum();
	}
	
	public int getIdByTitleAlbum(String title) {
		Album album = albumRepository.loadIdAlbumByTitle(title);
		if(album == null) return -1;
		return album.getId();
	}
	
	public List<Album> getAlbumsByGenre(String genre){
		List<Album> albums = albumRepository.loadAlbumByGenre(genre);
		if(albums.size() < 1 ) return null;
		return albums;
	}
	
	public Album getAlbumByTitleSong(String title) {
		Song song = songService.getSongByTitle(title);
		return albumRepository.loadById(song.getId_album());
	}
	
}
