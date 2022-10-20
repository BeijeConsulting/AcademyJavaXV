package it.beije.magazzino.controller;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.service.ProdottoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class ProductRestController {
    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private ProdottoRepository prodottoRepository;
    public ProductRestController(){
        System.out.println("Creazione oggetto ProductRestController");
    }

    /* Si richiede tramite GET la lista dei prodotti presenti nel magazzino */
    @GetMapping(value ="/listaProdotti")
    public List<Prodotto> listaProdotti(){
        List<Prodotto> prodotti =prodottoService.findAll();
        System.out.println("Numero dei prodotti presenti nel DB: "+ prodotti.size());
        return prodotti;
    }

    /* Si cerca tramite metodo GET il prodotto con un determinato ID presente nel magazzino */
    @GetMapping(value="/listaProdotti/{productId}")
    public Prodotto prodottoPerId(@PathVariable(name="productId")Integer idProdotto){
        return prodottoService.findById(idProdotto);
    }

    /* Caricamento nuovo prodotto nel magazzino*/
    @PostMapping(value="/nuovoProdotto")
    public Prodotto inserimentoProdotto(@RequestBody Prodotto prodotto){
        System.out.println("Inserimento tramite metodo POST del prodotto: "+prodotto);
        if(prodotto.getQuantita()>0){
            prodottoService.save(prodotto);
            System.out.println("Prodotto salvato");
        }
        return prodotto;
    }

    /* Modifica prodotto già esistente nel magazzino */
    @PutMapping(value="/modificaProdotto/{id}")
    public Prodotto modificaProdotto(@PathVariable(name="id")Integer id,@RequestBody Prodotto nuovoProdotto){
        System.out.println("Modifica dati tramite POST con l'id: "+id+" : "+ nuovoProdotto);

        if(id.compareTo(nuovoProdotto.getId())==0) {//Controllo che non si stia modificando un prodotto con gli stessi dati sul db
            Prodotto prodotto= prodottoService.findById(id);

            prodotto.setNome(nuovoProdotto.getNome());
            prodotto.setTipologia(nuovoProdotto.getTipologia());
            prodotto.setQuantita(nuovoProdotto.getQuantita());
            prodotto.setDescrizione(nuovoProdotto.getDescrizione());

            BeanUtils.copyProperties(nuovoProdotto,prodotto,"id");

            prodottoService.save(prodotto);

            return prodotto;
        }
        return null;
    }

    /* Cancellazione prodotto presente nel magazzino */
    @DeleteMapping(value="/cancellaProdotto/{id}")
    public String cancellaProdotto(@PathVariable(name="id")Integer id){
        System.out.println("Cancellazione del prodotto con ID:" +id);

        prodottoRepository.deleteById(id);

        return "{\"prodotto con id " +id+" rimosso con successo"+"\"}";
    }

    /* Lista dei prodotti con una tipologia specifica */
    @GetMapping(value="/visualizzaPerTipologia/{tipo}")
    public List<Prodotto> visualizzaPerTipologia(@PathVariable(name="tipo") String tipo){
        System.out.println("Visualizzazione prodotti per tipologia");
        return prodottoService.findByTipologia(tipo);
    }
    /* Ricerca dei prodotti per nome oppure per descrizione */
    @GetMapping(value={"/ricercaPerNome/{nome}","/ricercaPerDescrizione/{descrzione}"})
    public List<Prodotto> visualizzaPerNomeDescrizione(@PathVariable(name="nome")String nome, @PathVariable(name="descrizione")String descrizione){
        System.out.println("Ricerca prodotti per descrizione oppure per nome");
        return prodottoService.findByNomeOrDescrizione(nome,descrizione);
    }

}
