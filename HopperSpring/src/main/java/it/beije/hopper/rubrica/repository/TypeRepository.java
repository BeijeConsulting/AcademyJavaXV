package it.beije.hopper.rubrica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import it.beije.hopper.rubrica.model.Contact;
import it.beije.hopper.rubrica.model.TypeContact;


@Repository
public interface TypeRepository extends JpaRepository<TypeContact, Integer>{
	
	public abstract List<TypeContact> findAll();
}
