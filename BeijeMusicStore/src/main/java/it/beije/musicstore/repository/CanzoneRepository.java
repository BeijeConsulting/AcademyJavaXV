package it.beije.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.musicstore.model.Canzone;

@Repository
public interface CanzoneRepository extends JpaRepository<Canzone, Integer>{

}
