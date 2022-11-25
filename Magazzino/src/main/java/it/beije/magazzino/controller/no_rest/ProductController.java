package it.beije.magazzino.controller.no_rest;


import it.beije.magazzino.model.Product;
import it.beije.magazzino.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController() {
		System.out.println("creo un oggetto ProductController...");
	}


	@RequestMapping(value = "/products-html", method = RequestMethod.GET)
	public String products() {
		System.out.println("Inside js/producthtml");
		return "js/product-list";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Locale locale, Model model) {
		System.out.println("test : " + locale);
		List<Product> products = productService.findAll();
		System.out.println("Inside products() | .../products: " + products);
		model.addAttribute("products",products);
		return "product-list";
	}

	//TODO: UNFINISHED
	@RequestMapping(value = "/productbyname-id-html", method = RequestMethod.GET)
	public String productsbyid() {

		System.out.println("Inside productbyname-id-html");
		return "js/productby-id-or-name";
	}


	@RequestMapping(value = "/productbyid-form", method = RequestMethod.GET)
	public String productsbyidForm(@ModelAttribute("product") Product product, Locale locale, Model model) {
		System.out.println("test : " + locale);
		List<Product> products = productService.findAll();
		System.out.println("Inside products() | .../products: " + products);
		model.addAttribute("products", products);

		System.out.println("Product id: " + product.getId());

		return "productbyid-form";
	}

	@RequestMapping(value = "/productbyid", method = RequestMethod.GET)
	public String productsbyid(@ModelAttribute("product") Product product, Model model) {
		System.out.println("Inside /productbyid --- productsbyid");

		System.out.println("Product id: " + product.getId());

		Product productWithInfo = productService.findById(product.getId());
		System.out.println("Product found: " + productWithInfo);
		model.addAttribute("productWithInfo", productWithInfo);
		return "productbyid";
	}


	@GetMapping(value="/newproduct-form-html")
	public String newproductform(){
//		productService.save(product);

		return "js/newproduct-form";
	}

	@RequestMapping(value="/newproduct-form", method=RequestMethod.GET)
	public String newproductform(@ModelAttribute("product") Product product, Model model){
//		productService.save(product);

		List<Product> products = productService.findAll();
		System.out.println("Inside products() | .../products: " + products);
		model.addAttribute("products", products);

		System.out.println("Product id: " + product.getId());

		return "newproduct-form";
	}

	@RequestMapping(value = "/newproduct", method = RequestMethod.GET)
	public String newproduct(@ModelAttribute("product") Product product, Model model) {


		System.out.println("New Product: " + product);
		productService.save(product);
		System.out.println("Product after save: " + product);

		List<Product> products = productService.findAll();
//		System.out.println("Inside products() | .../products: " + products);
		model.addAttribute("products", products);



		return "newproduct-form";
	}

	@RequestMapping(value="/modifyproduct", method = RequestMethod.GET)
	public String modifyproductform(@ModelAttribute("product") Product product, Model model ){

		System.out.println("Selected Product: " + product);

		Product productToMod = productService.findById(product.getId()); // TODO: Fix --> USE PARAM INSTEAD OF MODEL!
		model.addAttribute("productToMod", productToMod);
		System.out.println("Product to MOD: " + productToMod);

		return "modifyingproduct-form";
	}


	//Starting page
	@RequestMapping(value="/modifyproduct-form", method = RequestMethod.GET)
	public String modifyproduct(@ModelAttribute("product") Product product, Model model ){
		List<Product> products = productService.findAll();
		System.out.println("Inside products() | .../products: " + products);
		model.addAttribute("products", products);

		return "modifyproduct-form";
	}



	@RequestMapping(value="/modifyingproduct", method = RequestMethod.POST )
	public String modifyingproduct(@ModelAttribute("product") Product product, @ModelAttribute("newProduct") Product newProduct, Model model){
		System.out.println("Modified Product: " + product);
		System.out.println();
		productService.save(product);
		return "main";//TODO: confirmation page
	}


	@RequestMapping(value="/deleteproduct-form-html", method=RequestMethod.GET)
	public String deleteproductform( ){
		return "js/deleteproduct-form";
	}


	//DELETE
	@RequestMapping(value="/deleteproduct-form", method=RequestMethod.GET)
	public String deleteproductform( @ModelAttribute("product") Product product, Model model ){
//		Product product = productService.findById(id);
//		System.out.println("Product to be deleted: " + product);
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "deleteproduct-form";
	}

	@RequestMapping(value="/deleteproduct", method=RequestMethod.POST)
	public String deleteproduct(@ModelAttribute("product") Product product){ //, @RequestParam(name="id", required = false) Integer id )

		System.out.println("Product to be deleted: " + product);
		productService.deleteById(product.getId());
		return "main";
	}

	// Pagina che restituisce la lista di tutti i prodotti di una specifica tipologia
	@RequestMapping(value="/productbytype-form", method=RequestMethod.GET)
	public String productbytypeform(@ModelAttribute("product") Product product, Model model){
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "productbytype-form";
	}


	@RequestMapping(value="/productbytype", method=RequestMethod.POST)
	public String productbytype(@ModelAttribute("product") Product product, Model model){

		System.out.println("product by type:" + product);
		List<Product> products = productService.findByType(product.getType());
		System.out.println("Products by type: " + products);
		model.addAttribute("products", products);
		model.addAttribute("type", products.get(0).getType());
		return "productbytype";
	}

	//  Pagina che restituisce la lista dei prodotti di una ricerca per nome e/o descrizione
	@RequestMapping(value="/productbynameordescription-form", method=RequestMethod.GET)
	public String productbynameordescriptionform(@ModelAttribute("product") Product product, Model model){
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "productbynameordescription-form";
	}

	@RequestMapping(value="/productbynameordescription", method=RequestMethod.POST)
	public String productbynameordescription(@ModelAttribute("product") Product product, Model model){
		String description = product.getDescription() == null ? "":product.getDescription();
		String name = product.getName() == null ? "":product.getName();
		model.addAttribute("name", name);
		model.addAttribute("description", description);
//		if( product.getDescription() != null )
		List<Product> productsByNameOrDesc = productService.findByNameOrDescription(product.getName(), product.getDescription());
		model.addAttribute("products", productsByNameOrDesc);
		return "productbynameordescription";
	}

}
