package it.beije.magazzino.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.magazzino.model.ContenutoProdotto;
import it.beije.magazzino.model.Product;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ProductRepository;
import it.beije.magazzino.service.ContenutoService;
import it.beije.magazzino.service.ProductService;
import it.beije.magazzino.service.SpedizioneService;


@Controller
public class ProductController {
	
	@Autowired
	private SpedizioneService spedizioneService;
	
	@Autowired
	private ContenutoService contenutoService;
	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	

	public ProductController() {
		System.out.println("creo un oggetto HelloController...");
	}
	
	
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String hello(HttpServletRequest request) {
		System.out.println("Hello Page Requested : " + request.getRequestURI());

		return "home";
	}
	
	
	  @RequestMapping(value = "/product", method = RequestMethod.GET)
	    public String index(HttpServletRequest request, Model model) {
	        System.out.println("Hello Page Requested : " + request.getRequestURI());

	        List<Product> product = productService.findAll();
	        model.addAttribute("product", product);
	       

	        return "prodotti"; // /WEB-INF/views/home.jsp

	    }
	  
	  @RequestMapping(value = "/prodottoById", method = RequestMethod.POST)
	    public String prodottoById(HttpServletRequest request, @RequestParam(name = "prodotto", required = false) int prodotto, Model model) {
	       
	        List<Product> prod = productService.findById(prodotto);
	        model.addAttribute("prodotto", prod);
	        return "prodotto"; // /WEB-INF/views/home.jsp
	    }
	  
	  @RequestMapping(value = "/addProd", method = RequestMethod.POST)
		public String insertProduct(Product prodotto, Model model) {
				
			productRepository.save(prodotto);
			System.out.println("prodotto post save : " + prodotto);
			model.addAttribute("addProd", prodotto);
			
			return "home";
		}
	  
	  @RequestMapping(value = "/modProd", method = RequestMethod.POST)
		public String modProduct(@RequestParam(name = "id", required = false) int id, Product prodotto, Model model) {
		  List<Product> product = productService.findById(id);
		  BeanUtils.copyProperties(prodotto, product, "id");
			productRepository.save(prodotto);
			System.out.println("prodotto post save : " + prodotto);
			model.addAttribute("addProd", prodotto);
			
			return "home";
		}
	  
	  
	  @RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String delProduct(HttpServletRequest request) {
	        return "delete"; 

	    }
	  
	  @RequestMapping(value = "/delete", method = RequestMethod.POST)
		public String delete(Product prodotto, Model model) {
				
			productRepository.delete(prodotto);
			System.out.println("prodotto post save : " + prodotto);
			
			
			return "home";
		}
	  
	  
	  @RequestMapping(value = "/prodottoByTipo", method = RequestMethod.GET)
	  public String tipologia(HttpServletRequest request, @RequestParam(name = "tipo", required = false) String tipo, Model model) {	       

	        List<Product> product = productService.findByTipo(tipo);
	        model.addAttribute("product", product);
	       

	        return "tipologia"; 

	    }
	  
	  @RequestMapping(value = "/prodottoByNomeDesc", method = RequestMethod.GET)
	  public String nomeDesc(HttpServletRequest request, @RequestParam(name = "name", required = false)String name, @RequestParam( name = "desc", required = false) String desc, Model model) {	       

		  if (name != null && name.length() > 0 ) {
	       
			  List<Product> product = productService.findByName(name);
		        model.addAttribute("product", product);
		       
		  }  if ( desc != null && desc.length() > 0) {  
			  List<Product> product = productService.findByDesc(desc);
		        model.addAttribute("product", product);
		       
		  }  if (name != null && name.length() > 0 && desc != null && desc.length() > 0) {  
			  List<Product> product = productService.findByNameAndDesc(name,desc);
		        model.addAttribute("product", product);
		  }
	        return "nomeDesc"; 

	    }
	  
	  @RequestMapping(value = "/spedizioni", method = RequestMethod.GET)
	    public String spedizioni(HttpServletRequest request, Model model) {
	        System.out.println("Hello Page Requested : " + request.getRequestURI());

	        List<Spedizione> spedizioni = spedizioneService.findAll();
	        model.addAttribute("spedizioni", spedizioni);
	       

	        return "spedizioni"; 

	    }
	  
	  
	  @RequestMapping(value="spedizioneContenuto",method=RequestMethod.GET)		
			public String getspedizioneContenuto(HttpServletRequest request, @RequestParam(name = "id", required = false) Integer id, Model model) {
		  List<ContenutoProdotto> contenuto=contenutoService.findBySpedizioneId(id);
				Spedizione spedizione=spedizioneService.findById(id);
				spedizione.setContenuto(contenuto);
				model.addAttribute("spedizione",spedizione);
				return "contenuto";
		}
	  
	 

}