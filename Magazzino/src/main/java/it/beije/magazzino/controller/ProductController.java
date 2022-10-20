package it.beije.magazzino.controller;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.repository.ProdottoRepository;
import it.beije.magazzino.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProdottoService prodottoService;
    @Autowired
    private ProdottoRepository prodottoRepository;
    public ProductController() {
        System.out.println("Creazione oggetto ProductController...");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        System.out.println("Pagina index richiesta dal client : " + request.getRequestURI());
        return "index"; // /WEB-INF/views/index.jsp
    }
    @RequestMapping(value = "/listaProdotti", method = RequestMethod.GET)
    public String listaProdotti(HttpServletRequest request, Model model){
        System.out.println("Pagina listaProdotti.jsp richiesta dal client"+ request.getRequestURI());//Stampa di debug

        List<Prodotto> listaProdotti = prodottoService.findAll();//Query SELECT * FROM magazzino

        System.out.println(listaProdotti.size());//Stampa di debug

        model.addAttribute("listaDeiProdotti",listaProdotti);//Aggiunta del risultato della query nell'oggetto model
        return "listaProdotti";// WEB-INF/views/listaProdotti.jsp
    }
    @RequestMapping(value = "/prodottoPerId", method=RequestMethod.GET)
    public String ricercaId(){
        return "prodottoPerId";
    }
    @RequestMapping(value = "/prodottoPerId", method=RequestMethod.POST)
    public String ricercaId(@RequestParam(name="idprodotto", required=false)Integer idProdotto, Model model){
        /*Stampe di debug*/
        System.out.println("Metodo POST per la ricerca del prodotto tramite ID");
        System.out.println(idProdotto);
        if(idProdotto>0){//Controllo se il dato passato dal form ha informazioni valide
            Prodotto prodotto=prodottoService.findById(idProdotto);//Ricerca dato nel database
            model.addAttribute("prodotto",prodotto);
            if (prodotto == null){
                model.addAttribute("errore","Prodotto inesistente");
            }
        }else{
            model.addAttribute("errore","Prodotto inesistente");
        }
        return "prodottoPerId"; // WEB-INF/views/prodottoPerId.jsp
    }
    @RequestMapping(value="/nuovoProdotto", method=RequestMethod.GET)
    public String nuovoProdotto(){
        return "nuovoProdotto";  // WEB-INF/views/nuovoProdotto.jsp
    }
    @RequestMapping(value="/nuovoProdotto", method=RequestMethod.POST)
    public String nuovoProdotto(
            @RequestParam(name="nomeProdotto",required=true) String nome,
            @RequestParam(name="tipologiaProdotto",required=true) String tipo,
            @RequestParam(name="quantita",required=true)Integer quantita,
            @RequestParam(name="descrizione",required=true)String descrizione,
            Model model){
        System.out.println("Metodo POST per l'inserimento di un prodotto nel db con i seguenti dati:");
        System.out.println("Nome:\t"+nome+"\nTipologia\t"+tipo+"\nQuantità\t"+quantita+"\nDescrizione\t"+descrizione);

        Prodotto prodotto=new Prodotto();//Dichiarazione oggetto da salvare
        prodotto.setId(0);
        prodotto.setNome(nome);
        prodotto.setTipologia(tipo);
        prodotto.setQuantita(quantita);
        prodotto.setDescrizione(descrizione);

        System.out.println("Prodotto PRE-inserimento nel db :"+ prodotto);
        if ((prodotto.getQuantita() instanceof Integer) && prodotto.getQuantita()>0){
            prodottoService.save(prodotto);
            model.addAttribute("stato","Prodotto caricato correttamente");
            System.out.println("Prodotto caricato");
        }else{
            model.addAttribute("errore","Dati non validi, riprovare");
        }

        return "nuovoProdotto";  // WEB-INF/views/nuovoProdotto.jsp
    }

    @RequestMapping(value="/modificaProdotto", method=RequestMethod.GET)
    public String modificaProdotto(){
        return "modificaProdotto";
    }
    @RequestMapping(value="/modificaProdotto", method = RequestMethod.POST)
    public String modificaProdotto(@RequestParam(name="idProdotto",required=true) Integer id,
                                   @RequestParam(name="nomeProdotto",required=true) String nome,
                                   @RequestParam(name="tipologiaProdotto",required=true) String tipo,
                                   @RequestParam(name="quantita",required=true)Integer quantita,
                                   @RequestParam(name="descrizione",required=true)String descrizione,
                                   Model model ){
        Prodotto esistente;//Oggetto con cui deve essere confrontato l'oggetto con i dati del form
        Prodotto prodotto=new Prodotto();//Oggetto che contiene dati del form

        prodotto.setId(id);
        esistente=prodottoService.findById(prodotto.getId());/* Query con memorizzazione del risultato
                                                                su oggetto prodotto esistente in magazzino */
        if(esistente!=null) {//Verifica che sia presente il prodotto col determinato id passato da form in modificaProdotto.jsp
            //Riempimento dati oggetti provenienti dal fore
            prodotto.setNome(nome);
            prodotto.setTipologia(tipo);
            prodotto.setQuantita(quantita);
            prodotto.setDescrizione(descrizione);

            System.out.println(prodotto.toString());

            //Controllo modifica con gli stessi valori presenti del prodotto nel Magazzino
            if((esistente.getNome().equals(prodotto.getNome())) &&
                    (esistente.getTipologia().equals(prodotto.getTipologia())) &&
                    (esistente.getQuantita().equals(prodotto.getQuantita())) &&
                    (esistente.getDescrizione().equals(prodotto.getDescrizione()))){
                model.addAttribute("errore","Si stanno modificando gli stessi valori del prodotto presente in Magazzino");
            }else{
                prodottoService.save(prodotto);
                System.out.println("Modifica avvenuta con successo");
                model.addAttribute("stato","Modifica avvenuta con successo");
            }
        }
        return "modificaProdotto";  // WEB-INF/views/modificaProdotto.jsp
    }
    @RequestMapping(value="/cancellaProdotto", method=RequestMethod.GET)
    public String cancellaProdotto(){
        return "cancellaProdotto";
    }
    @RequestMapping(value="/cancellaProdotto", method=RequestMethod.POST)
    public String cancellaProdotto(@RequestParam(name="idProdotto")Integer id, Model model){
        System.out.println("Cancellazione prodotto dal database");
        if (id!=null) {
            prodottoRepository.deleteById(id);
        }else{
            model.addAttribute("errore", "Prodotto non cancellato riprovare");
        }
        model.addAttribute("stato", "Prodotto Cancellato correttamente");
        return "cancellaProdotto";
    }
    @RequestMapping(value = "/ricercaPerTipologia", method=RequestMethod.GET)
    public String ricercaPerTipologia(){
        return "ricercaPerTipologia";
    }
    @RequestMapping(value = "/ricercaPerTipologia", method=RequestMethod.POST)
    public String ricercaPerTipologia(@RequestParam("tipoProdotto")String tipo,Model model){
        System.out.println("Ricerca prodotti per tipologia");
        System.out.println(tipo);
        List<Prodotto> prodotto=prodottoService.findByTipologia(tipo);
        if(prodotto.isEmpty()){
            model.addAttribute("errore", "Ricerca fallita, riprovare");
        }else{
            model.addAttribute("risultato", prodotto);
        }
        return "ricercaPerTipologia";
    }

}
