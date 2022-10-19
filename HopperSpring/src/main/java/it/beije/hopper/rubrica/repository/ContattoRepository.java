package it.beije.hopper.rubrica.repository;

import it.beije.hopper.rubrica.model.Contatto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Integer> {


    public abstract Optional<Contatto> findById(Integer id);


}
