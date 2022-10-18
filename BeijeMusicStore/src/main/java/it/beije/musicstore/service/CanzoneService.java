package it.beije.musicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.musicstore.model.Canzone;
import it.beije.musicstore.repository.CanzoneRepository;

@Service
public class CanzoneService {

	@Autowired
	CanzoneRepository canzoneRepository;
	
	public List<Canzone> getCanzoniByAlbum(Integer album){
		return canzoneRepository.findByAlbumId(album);
	}
	
	public List<Canzone> getCanzoniByArtist(Integer artist){
		return canzoneRepository.findByArtistaId(artist);
	}
	
	public List<Canzone> getCanzoniByGenere(String genere){
		return canzoneRepository.findByGenere(genere);
	}
	
	public Canzone getCanzoniById(Integer id) throws Exception{
		Optional<Canzone> canzone=canzoneRepository.findById(id);
		if(!canzone.isPresent())
			throw new Exception("Canzone non trovata");
		return canzone.get();
	}

	public void checkCanzone(Canzone canzone) {
		if(canzone.getArtistaId()==null) {
			throw new IllegalArgumentException("Il campo 'id_artista' non può essere null");
		}
		
		if(canzone.getGenere()==null) {
			throw new IllegalArgumentException("Il campo 'genere' non può essere null");
		}
		
		if(canzone.getDataDiUscita()==null) {
			throw new IllegalArgumentException("Il campo 'data_di_uscita' non può essere null");
		}
		
		if(canzone.getTitolo()==null) {
			throw new IllegalArgumentException("Il campo 'titolo' non può essere null");
		}
		
		if(canzone.getAlbumId()==null) {
			throw new IllegalArgumentException("Il campo 'id_album' non può essere null");
		}
		
	}

	public void insert(Canzone canzone) {
		canzoneRepository.save(canzone);
		
	}
}
