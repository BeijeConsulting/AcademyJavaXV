package it.beije.magazzino.repository;

import it.beije.magazzino.model.Spedizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SpedizioneRepository extends JpaRepository<Spedizione, Integer> {

    @Query(nativeQuery = true, value = "SELECT spedizione.id, spedizione.codice, spedizione.destinatario, spedizione.indirizzo,spedizione.data_spedizione,spedizione.data_ricezione,prodotto.name, prodotto.quantity, contenuto_spedizione.quantita FROM spedizione, prodotto, contenuto_spedizione WHERE spedizione.id = contenuto_spedizione.spedizione_id AND contenuto_spedizione.prodotto_id=prodotto.id AND spedizione.id = :id")
   public abstract Spedizione findSpedizione(@Param("id") Integer id);
}
