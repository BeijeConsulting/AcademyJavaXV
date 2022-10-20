package it.beije.hopper.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.beije.hopper.model.Product;
import it.beije.hopper.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

	@Autowired
	private ProductService productService;

	public HelloController() {
		System.out.println("creo un oggetto HelloController...");
	}
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());

		return "home"; // /WEB-INF/views/home.jsp
	}

	@RequestMapping(value = {"/listP"}, method = RequestMethod.GET)
	public String listP(HttpServletRequest request, Model model) {
		System.out.println("Lista prodotti : " + request.getRequestURI());
		try{
			List<Product> lista = productService.findAll();
			model.addAttribute("prodotti", lista);
			return "listP";
		}catch(Exception e){
			model.addAttribute("error", "Qualcosa è andato storto! Riprova");
			return "home";
		}
	}

	@RequestMapping(value = {"/infoP"}, method = RequestMethod.GET)
	public String infoP(HttpServletRequest request, Model model,  @RequestParam(name = "id", required = false) Integer id) {
		System.out.println("Info prodotto: " + id);
		try{
			Product p = productService.findById(id);
			if(p == null){throw new Exception();}
			model.addAttribute("dettaglio", p);
			System.out.println(p);
			return "infoP";
		}catch (Exception e) {
			model.addAttribute("error", "Qualcosa è andato storto! Riprova inserendo un ID valido");
			return "home";
		}
	}

	@RequestMapping(value = {"/newP"}, method = RequestMethod.POST)
	public String newP(HttpServletRequest request, Model model,
					   @RequestParam(name = "nome", required = false) String nome,
					   @RequestParam(name = "tipo", required = false) String tipo,
					   @RequestParam(name = "quantita", required = false) Integer quantita,
					   @RequestParam(name = "descrizione", required = false) String descrizione) {
		System.out.println("Creating new record...");
		try{
			Product p = new Product();
			p.setNome(nome);
			p.setTipo(tipo);
			p.setQuantita(quantita);
			p.setDescrizione(descrizione);
			model.addAttribute("newP", p);
			productService.saveProduct(p);
			return "newP";
		}catch (Exception e){
			model.addAttribute("error", "Qualcosa è andato storto! Riprova inserendo un valori validi");
			return "home";
		}
	}

	@RequestMapping(value = {"/editP"}, method = RequestMethod.POST)
	public String editP(HttpServletRequest request, Model model,
						@RequestParam(name = "id", required = false) Integer id,
						@RequestParam(name = "campo", required = false) String campo,
						@RequestParam(name = "valore", required = false) String valore) {
		System.out.println("Editing record with ID : " + id + "...");

		try{
			Product p = productService.findById(id);
			switch (campo){
				case "nome": p.setNome(valore);break;
				case "tipo": p.setTipo(valore);break;
				case "quantita": p.setQuantita(Integer.parseInt(valore));break;
				case "descrizione": p.setDescrizione(valore);break;
			}
			System.out.println(p);
			model.addAttribute("editP", p);
			productService.saveProduct(p);
			return "infoP";
		}catch (Exception e){
			model.addAttribute("error", "Qualcosa è andato storto! Riprova inserendo un valori validi");
			return "home";
		}
	}

	@RequestMapping(value = {"/deleteP"}, method = RequestMethod.GET)
	public String deleteP(HttpServletRequest request, Model model,  @RequestParam(name = "id", required = false) Integer id) {
		System.out.println("Deleting record with ID : " + id + "...");
		try{
			Product p = productService.findById(id);
			productService.deleteProduct(p);
			model.addAttribute("deleteP", p);
			System.out.println(p);
			return "infoP";
		}catch (Exception e){
			model.addAttribute("error", "Qualcosa è andato storto! Riprova inserendo un ID valido");
			return "home";
		}
	}

	@RequestMapping(value = {"/findPbyTipo"}, method = RequestMethod.GET)
	public String findPbyTipo(HttpServletRequest request, Model model,  @RequestParam(name = "tipo", required = false) String tipo) {
		System.out.println("Lista prodotti by tipo...");

		try {
			List<Product> list = productService.listByTipo(tipo);
			model.addAttribute("prodotti", list);
			return "listP";
		}catch (Exception e){
			model.addAttribute("error", "Qualcosa è andato storto! Riprova inserendo un ID valido");
			return "home";
		}
	}

	@RequestMapping(value = {"/findPbyNome_Desc"}, method = RequestMethod.GET)
	public String findPbyNome_Desc(HttpServletRequest request, Model model,
								   @RequestParam(name = "nome", required = false) String nome,
								   @RequestParam(name = "descrizione", required = false) String descrizione) {
		System.out.println("Lista prodotti by tipo |& desc...");
		try{
			List<Product> prodotti = new ArrayList<>();
			System.out.println(nome + " " +descrizione);
			if((!nome.isEmpty()) && (!descrizione.isEmpty())){
				System.out.println(nome+" AND "+descrizione);
				prodotti = productService.findByNomeAndDescrizione(nome, descrizione);
			}else if(!nome.isEmpty() | !descrizione.isEmpty()){
				System.out.println("OR");
				prodotti = productService.findByNomeOrDescrizione(nome, descrizione);
			}else{
				model.addAttribute("error", "Devi inserire almeno un nome o una descrizione");
			}
			model.addAttribute("prodotti", prodotti);
			return "listP";
		}catch (Exception e){
			model.addAttribute("error", "Qualcosa è andato storto! Riprova inserendo un ID valido");
			return "home";
		}
	}

}
