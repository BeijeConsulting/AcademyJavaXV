package it.beije.magazzino.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.repository.SpedizioneRepository;

@Service
public class SpedizioneService {
	
	@Autowired
	private SpedizioneRepository spedizioneRepository;

	@Autowired
	EntityManager em;
	
	public List<Spedizione> findAll() {
		return spedizioneRepository.findAll();
	}

	public List<Spedizione> gottaCatchEmAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Spedizione> cq = cb.createQuery(Spedizione.class);
        
        Root<Spedizione> prod = cq.from(Spedizione.class);

        TypedQuery<Spedizione> query = em.createQuery(cq);
        return query.getResultList();
	}

}
