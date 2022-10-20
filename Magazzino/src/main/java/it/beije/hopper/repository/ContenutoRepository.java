package it.beije.hopper.repository;

import it.beije.hopper.model.Contenuto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContenutoRepository extends JpaRepository<Contenuto, Integer> {

    public abstract List<Contenuto> findAll();
    public abstract List<Contenuto> findByIdSpedizione(int id);

}
