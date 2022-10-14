package it.beije.musicstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.model.Album;
import it.beije.musicstore.model.Artist;
import it.beije.musicstore.repository.AlbumRepository;
import it.beije.musicstore.repository.ArtistRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private ArtistRepository artistRepository;
	
	public List<Album> listAlbumByArtist(Integer id_artist){
		
		//Artist artist = artistRepository.loadByName(name_artist);
		//Artist artist = artistRepository.loadById(id_artist);
		
//		List<Album> list = null;
//		list = albumRepository.loadByArtist(id_artist);
//		
//		
//		
//		for(Album a : list) System.out.println(a.getTitle());
		
		return albumRepository.loadByArtist(id_artist);
	}
	
}
