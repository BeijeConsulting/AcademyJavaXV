package it.beije.rubrica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.rubrica.model.Contatto;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto,Integer>{

	public abstract Optional<Contatto> findById(Integer id);
}
