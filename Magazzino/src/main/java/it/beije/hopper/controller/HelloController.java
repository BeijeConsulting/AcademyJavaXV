package it.beije.hopper.controller;

import javax.servlet.http.HttpServletRequest;

import it.beije.hopper.model.Contenuto;
import it.beije.hopper.model.Product;
import it.beije.hopper.model.Spedizione;
import it.beije.hopper.service.ContenutoService;
import it.beije.hopper.service.ProductService;
import it.beije.hopper.service.SpedizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ContenutoService contenutoService;
	@Autowired
	private SpedizioneService spedizioneService;

	public HelloController() {
		System.out.println("creo un oggetto HelloController...");
	}

	@RequestMapping(value = {""}, method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());

		return "home"; // /WEB-INF/views/home.jsp
	}
//
//	@RequestMapping(value = {"/listS"}, method = RequestMethod.GET)
//	public ResponseEntity<List<Spedizione>> listS(HttpServletRequest request, Model model) {
//		System.out.println("Lista spedizioni : " + request.getRequestURI());
//			List<Spedizione> lista = spedizioneService.findAll();
//			model.addAttribute("spedizioni", lista);
//			return ResponseEntity.ok(lista);
//	}
//
//	@RequestMapping(value = {"/listP"}, method = RequestMethod.GET)
//	public ResponseEntity<List<Product>> listP(HttpServletRequest request, Model model) {
//		System.out.println("Lista prodotti : " + request.getRequestURI());
//			List<Product> lista = productService.findAll();
//			model.addAttribute("prodotti", lista);
//			return ResponseEntity.ok(lista);
//	}
//
//	@RequestMapping(value = {"/infoP/{id}"}, method = RequestMethod.GET)
//	public ResponseEntity<Product> infoP(HttpServletRequest request, Model model,  @PathVariable(name = "id", required = false) Integer id) {
//		System.out.println("Info prodotto: " + id);
//			Product p = productService.findById(id);
//			model.addAttribute("dettaglioP", p);
//			System.out.println(p);
//			return ResponseEntity.ok(p);
//	}
//
//	@RequestMapping(value = {"/infoS/{id}"}, method = RequestMethod.GET)
//	public ResponseEntity<List<Contenuto>> infoS(HttpServletRequest request, Model model,  @PathVariable(name = "id", required = false) Integer id) {
//		System.out.println("Info spedizione: " + id);
//		Spedizione s = spedizioneService.findById(id);
//		List<Contenuto> c = contenutoService.findByIdSpedizione(id);
//		model.addAttribute("dettaglioS", s);
//		model.addAttribute("contenutoS", c);
//		System.out.println("spedizione: "+s);
//		System.out.println("contenuto: "+c);
//		return ResponseEntity.ok(c);
//	}
//
//	@RequestMapping(value = {"/newP"}, method = RequestMethod.POST)
//	public ResponseEntity<Product> newP(HttpServletRequest request, Model model, @RequestBody Product product){
//		System.out.println("Creating new record...");
//			Product p = productService.saveProduct(product);
//			return ResponseEntity.ok(p);
//	}
//
//	@RequestMapping(value = {"/editP"}, method = RequestMethod.PUT)
//	public String editP(HttpServletRequest request, Model model,
//						@RequestParam(name = "id", required = false) Integer id,
//						@RequestParam(name = "campo", required = false) String campo,
//						@RequestParam(name = "valore", required = false) String valore) {
//		System.out.println("Editing record with ID : " + id + "...");
//
//		try{
//			Product p = productService.findById(id);
//			switch (campo){
//				case "nome": p.setNome(valore);break;
//				case "tipo": p.setTipo(valore);break;
//				case "quantita": p.setQuantita(Integer.parseInt(valore));break;
//				case "descrizione": p.setDescrizione(valore);break;
//			}
//			System.out.println(p);
//			model.addAttribute("editP", p);
//			productService.saveProduct(p);
//			return "info";
//		}catch (Exception e){
//			model.addAttribute("error", "Qualcosa è andato storto! Riprova inserendo un valori validi");
//			return "home";
//		}
//	}
//
//	@RequestMapping(value = {"/deleteP"}, method = RequestMethod.GET)
//	public String deleteP(HttpServletRequest request, Model model,  @RequestParam(name = "id", required = false) Integer id) {
//		System.out.println("Deleting record with ID : " + id + "...");
//		try{
//			Product p = productService.findById(id);
//			productService.deleteProduct(p);
//			model.addAttribute("deleteP", p);
//			System.out.println(p);
//			return "info";
//		}catch (Exception e){
//			model.addAttribute("error", "Qualcosa è andato storto! Riprova inserendo un ID valido");
//			return "home";
//		}
//	}
//
//	@RequestMapping(value = {"/findPbyTipo"}, method = RequestMethod.GET)
//	public String findPbyTipo(HttpServletRequest request, Model model,  @RequestParam(name = "tipo", required = false) String tipo) {
//		System.out.println("Lista prodotti by tipo...");
//
//		try {
//			List<Product> list = productService.listByTipo(tipo);
//			model.addAttribute("prodotti", list);
//			return "listP";
//		}catch (Exception e){
//			model.addAttribute("error", "Qualcosa è andato storto! Riprova inserendo un ID valido");
//			return "home";
//		}
//	}
//
//	@RequestMapping(value = {"/findPbyNome_Desc"}, method = RequestMethod.GET)
//	public String findPbyNome_Desc(HttpServletRequest request, Model model,
//								   @RequestParam(name = "nome", required = false) String nome,
//								   @RequestParam(name = "descrizione", required = false) String descrizione) {
//		System.out.println("Lista prodotti by tipo |& desc...");
//		try{
//			List<Product> prodotti = new ArrayList<>();
//			System.out.println(nome + " " +descrizione);
//			if((!nome.isEmpty()) && (!descrizione.isEmpty())){
//				System.out.println(nome+" AND "+descrizione);
//				prodotti = productService.findByNomeAndDescrizione(nome, descrizione);
//			}else if(!nome.isEmpty() | !descrizione.isEmpty()){
//				System.out.println("OR");
//				prodotti = productService.findByNomeOrDescrizione(nome, descrizione);
//			}else{
//				model.addAttribute("error", "Devi inserire almeno un nome o una descrizione");
//			}
//			model.addAttribute("prodotti", prodotti);
//			return "listP";
//		}catch (Exception e){
//			model.addAttribute("error", "Qualcosa è andato storto! Riprova inserendo un ID valido");
//			return "home";
//		}
//	}

}
