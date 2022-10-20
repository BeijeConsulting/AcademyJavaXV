package it.beije.magazzino.repository;

import it.beije.magazzino.model.ContenutoSpedizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenutoSpedizioneRepository extends JpaRepository<ContenutoSpedizione, Integer> {

    ContenutoSpedizione findSpedizioneByProdottoId(Integer id);
}
