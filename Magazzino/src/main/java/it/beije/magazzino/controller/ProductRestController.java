package it.beije.magazzino.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.magazzino.model.ContenutoProdotto;
import it.beije.magazzino.model.Product;
import it.beije.magazzino.model.Spedizione;
import it.beije.magazzino.repository.ProductRepository;
import it.beije.magazzino.service.ContenutoService;
import it.beije.magazzino.service.ProductService;
import it.beije.magazzino.service.SpedizioneService;


@RestController
@RequestMapping(value = "api")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ProductRestController {

	public ProductRestController() {
		System.out.println("creo un oggetto MyRestController...");
	}
	@Autowired
	private SpedizioneService spedizioneService;
	
	@Autowired
	private ContenutoService contenutoService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	 @GetMapping(value = "/product")
	  public  ResponseEntity<List<Product>>prodotti() {      
	      List<Product> prodotti = productService.findAll();
	     
	   
	      return ResponseEntity.ok(prodotti); 
	  }
	 
	 @PostMapping(value = "/prodottoById")
	  public  List<Product> prodottoById( @RequestBody Product prod) {      
	      List<Product> prodotto = productService.findById(prod.getId());
	     
	   
	      return prodotto;
	  }
	 
	 @PostMapping(value = "/addProd")
	  public  ResponseEntity<Product> addProd( @RequestBody Product prod) {      
		 productService.save(prod);
	     
	   
	      return ResponseEntity.ok(prod); 
	  }
	 
	 @PutMapping(value = "/modProd/{id}")
		public Product updateProduct(@PathVariable(name = "id", required = false) Integer id, @RequestBody Product newData) {
			
			if (id.compareTo(newData.getId()) == 0) {
				
				List<Product> prod = productService.findById(id);
	
				BeanUtils.copyProperties(newData, prod, "id");
				
				productService.save(newData);

				return newData;
			} else
				throw new IllegalArgumentException("id non corrispondenti");
		}
	 
	 @DeleteMapping(value = "/delete/{id}")
		public String deleteUser(@PathVariable(name = "id") Integer id) {
			System.out.println("DELETE deleteUser : " + id);
			
			productRepository.deleteById(id);
			
			return "{\"message\":\"rimosso user " + id + "\"}";
		}
	 
	 @PostMapping(value = "/prodottoByTipo")
	  public  List<Product> prodottiByTipo(@RequestBody Product prodotto) {      
	      List<Product> prodotti = productService.findByTipo(prodotto.getTipo());
	     
	   
	      return prodotti; 
	  }
	 
	 @PostMapping(value = "/prodottoByNomeDesc")
	  public  List<Product> prodottiByNomeDesc(@RequestBody Product prodotto) { 
		 List<Product> prodotti = null;
		 if (prodotto.getDesc()== null||prodotto.getDesc()== "") {
			  prodotti = productService.findByName(prodotto.getName());
		 }else  if (prodotto.getName()== null||prodotto.getName()== "") {
			 prodotti = productService.findByDesc(prodotto.getDesc());
		 }else if ((prodotto.getName()!= null && prodotto.getDesc()!= null)||(prodotto.getName()!= "" && prodotto.getDesc()!= "")){
	       prodotti = productService.findByNameAndDesc(prodotto.getName(), prodotto.getDesc());
		 }
	   
	      return prodotti; 
	  }
	 
	 @GetMapping(value = "/spedizioni")
	  public  List<Spedizione> spedizioni() {      
	      List<Spedizione> spedizioni = spedizioneService.findAll();
	      return spedizioni; 
	  }
	 
	 
	 @GetMapping(value="/spedizioneContenuto/{id}")
		public Spedizione spedizioneContenuto(@PathVariable(name = "id", required = false) Integer id)  {
			
		  List<ContenutoProdotto> contenuto=contenutoService.findBySpedizioneId(id);
			Spedizione spedizione=spedizioneService.findById(id);
			spedizione.setContenuto(contenuto);
			return spedizione;
		}

}