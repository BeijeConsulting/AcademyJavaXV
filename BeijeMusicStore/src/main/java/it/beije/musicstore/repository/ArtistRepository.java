package it.beije.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.musicstore.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{

	public abstract Artist findByName(String name);
	//public abstract List<Product> findAll();
	
}
