package it.beije.magazzino.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
	private ProdottoRepository prodottoRepository;
	
	@Autowired
	EntityManager em;

	public Prodotto findById(Integer id) {
		Optional<Prodotto> p = prodottoRepository.findById(id);
		
		if (!p.isPresent()) throw new IllegalArgumentException("Prodotto non trovato con id " + id);

		return p.get();
	}

	public Prodotto save(Prodotto prodotto) {
		return prodottoRepository.save(prodotto);
	}

	public List<Prodotto> findAll() {
		return prodottoRepository.findAll();
	}

	public List<Prodotto> findByTipologia(String tipologia) {
		return prodottoRepository.findByTipologia(tipologia);
	}

	public List<Prodotto> findByNome(String nome) {
		return prodottoRepository.findByNome(nome);
	}

	public List<Prodotto> findByNomeAndDescrizione(String nome, String descrizione) {
		return prodottoRepository.findByNomeAndDescrizione(nome,descrizione);
	}

	public List<Prodotto> findByDescrizione(String descrizione) {
		return prodottoRepository.findByDescrizione(descrizione);
	}

	public List<Prodotto> gottaCatchEmAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Prodotto> cq = cb.createQuery(Prodotto.class);
        
        Root<Prodotto> prod = cq.from(Prodotto.class);

        TypedQuery<Prodotto> query = em.createQuery(cq);
        return query.getResultList();
	}

	public Prodotto getById(Integer id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Prodotto> cq = cb.createQuery(Prodotto.class);

        Root<Prodotto> prod = cq.from(Prodotto.class);
        Predicate identificativo = cb.equal(prod.get("id"), id);
        cq.where(identificativo);

        TypedQuery<Prodotto> query = em.createQuery(cq);
        return query.getSingleResult();
	}
	
	public List<Prodotto> getByTipologia(String tipologia) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Prodotto> cq = cb.createQuery(Prodotto.class);

        Root<Prodotto> prod = cq.from(Prodotto.class);
        Predicate identificativo = cb.equal(prod.get("tipologia"), tipologia);
        cq.where(identificativo);

        TypedQuery<Prodotto> query = em.createQuery(cq);
        return query.getResultList();
	}







}
