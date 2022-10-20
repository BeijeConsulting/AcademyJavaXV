package it.beije.magazzino.repository;

import it.beije.magazzino.model.ContenutoSpedizione;
import it.beije.magazzino.model.Spedizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ContenutoSpedizioneRepository extends JpaRepository<ContenutoSpedizione, Integer>{

    public abstract Optional<ContenutoSpedizione> findById(Integer id);

    public abstract Optional<ContenutoSpedizione> findBySpedizione_id(Integer id);

}
