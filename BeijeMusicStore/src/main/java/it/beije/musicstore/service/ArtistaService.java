package it.beije.musicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.model.Artista;
import it.beije.musicstore.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	ArtistaRepository artistaRepository;
	
	public List<Artista> getByGenere(String genere){		
		return artistaRepository.findByGenere(genere);
	}

	public Artista getByIdArtista(Integer id) throws Exception{
		Optional<Artista> artista=artistaRepository.findById(id);
		if(!artista.isPresent())
			throw new Exception();
		
		return artista.get();
	}
	
	public void save(Artista artista) {
		 artistaRepository.save(artista);
	}
	
	public void checkArtista(Artista artista) {
		
		if(artista.getNome()==null) {
			throw new IllegalArgumentException("Il campo 'nome' non può essere null");
		}
		
		if(artista.getGenere()==null) {
			throw new IllegalArgumentException("Il campo 'genere' non può essere null");
		}
	}

}
