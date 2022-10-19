package it.beije.hopper.rubrica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import it.beije.hopper.rubrica.model.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	public abstract List<Contact> findAll();
}
