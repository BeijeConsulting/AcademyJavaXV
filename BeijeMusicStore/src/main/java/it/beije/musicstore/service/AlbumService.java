package it.beije.musicstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.musicstore.repository.AlbumRepository;
import it.beije.musicstore.repository.CanzoneRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
}
