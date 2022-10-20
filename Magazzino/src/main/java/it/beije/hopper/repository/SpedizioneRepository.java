package it.beije.hopper.repository;

import it.beije.hopper.model.Contenuto;
import it.beije.hopper.model.Spedizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpedizioneRepository extends JpaRepository<Spedizione, Integer> {

    public abstract List<Spedizione> findAll();

    public abstract Spedizione findById(int id);


}
