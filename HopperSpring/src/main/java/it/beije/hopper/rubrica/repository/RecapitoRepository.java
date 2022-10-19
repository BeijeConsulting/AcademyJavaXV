package it.beije.hopper.rubrica.repository;

import it.beije.hopper.rubrica.model.Recapito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecapitoRepository extends JpaRepository<Recapito, Integer> {


    public abstract Optional<Recapito> findById(Integer id);


}
