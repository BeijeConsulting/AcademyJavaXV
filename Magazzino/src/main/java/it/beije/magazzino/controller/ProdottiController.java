package it.beije.magazzino.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.service.ProdottoService;


@Controller
public class ProdottiController {
	
	@Autowired
	ProdottoService prodottoService;

	//Visualizzazione lista prodotti
	@RequestMapping(value = "p_list", method = RequestMethod.GET)
	public String showProductList(HttpServletRequest request, Model model){

		model.addAttribute("articlesList", prodottoService.findAllArticles());
		return "productList";
	}

	//Pagina in cui si inserisce l'id dell'articolo da cercare. Valido anche per l'aggiornamento e la cancellazione di un prodotto
	@RequestMapping(value = "product", method = RequestMethod.GET)
	public String insertIdProduct(HttpServletRequest request, Model model){

		return "idArticleToShow";
	}

	//Visualizzazione articolo corrispondente all'id inserito
	@RequestMapping(value = "product_details", method = RequestMethod.GET)
	public String showSelectedProduct(HttpServletRequest request, Model model, @RequestParam(name = "id") Integer id){

		Prodotto prodotto = prodottoService.findSpecificArticle(id);
		model.addAttribute("selectedArticle", prodotto);
		return "productDetails";
	}

	//Inserimento dati del prodotto da aggiungere al DB
	@RequestMapping(value = "insertArticle", method = RequestMethod.GET)
	public String insertProductDatas(HttpServletRequest request, Model model){

		return "insertData";
	}

	//Inserimento nuovo prodotto nel DB
	@RequestMapping(value = "product_insertion", method = RequestMethod.POST)
	public String saveProductInDb(HttpServletRequest request, Model model, @RequestParam(name = "name") String name,
								  @RequestParam(name = "type") String type,@RequestParam(name = "quantity") Integer quantity,
								  @RequestParam(name = "description") String description){

		Prodotto prodotto = new Prodotto();
		prodotto.setName(name);
		prodotto.setType(type);
		prodotto.setQuantity(quantity);
		prodotto.setDescription(description);

		model.addAttribute("savedArticle", prodotto);

		return "productInsertion";
	}

	//Inserire id articolo da modificare
	@RequestMapping(value = "productUpdate", method = RequestMethod.GET)
	public String idProductToUpdate(HttpServletRequest request, Model model){

		return "idArticleToUpdate";
	}

	//Inserire dati articolo da modificare
	@RequestMapping(value = "product_toUpdate", method = RequestMethod.GET)
	public String infosProductToUpdate(HttpServletRequest request, Model model){

		return "infosProductToUpdate";
	}

	//Inserire articolo modificato nel DB
	@RequestMapping(value = "updatedProduct", method = RequestMethod.POST)
	public String updateProduct(HttpServletRequest request, Model model, @RequestParam(name = "id") Integer id,
								@RequestParam(name = "name") String name, @RequestParam(name = "type") String type,
								@RequestParam(name = "quantity") Integer quantity, @RequestParam(name = "description") String description){

		Prodotto prodotto = prodottoService.findSpecificArticle(id);

		if(name.length() > 0 || name != null) prodotto.setName(name);
		if(type.length() > 0 || type != null) prodotto.setType(type);
		if(quantity >= 0) prodotto.setQuantity(quantity);
		if(description.length() > 0 || description != null) prodotto.setDescription(description);

		prodottoService.insert(prodotto);
		model.addAttribute("updatedArticle", prodotto);

		return "showUpdatedArticle";
	}

	//Inserire id articolo da eliminare
	@RequestMapping(value = "productDelete", method = RequestMethod.GET)
	public String idArticleToDelete(HttpServletRequest request, Model model){

		return "idArticleToDelete";
	}

	//Cancellazione articolo dal DB
	@RequestMapping(value = "product_toDelete", method = RequestMethod.POST)
	public String deleteProduct(HttpServletRequest request, Model model, @RequestParam(name = "id") Integer id){

		Prodotto prodotto = prodottoService.findSpecificArticle(id);
		model.addAttribute("deletedArticle", prodotto);
		prodottoService.deleteSpecificArticle(id);

		return "deletedArticle";
	}

	//Ricerca articolo per tipologia
	@RequestMapping(value = "researchByType", method = RequestMethod.GET)
	public String searchArticleByType(HttpServletRequest request, Model model){

		return "searchArticleByType";
	}

	//Visulizzazione articolo trovato per tipologia
	@RequestMapping(value = "article_byType", method = RequestMethod.GET)
	public String findArticleByType(HttpServletRequest request, Model model, @RequestParam(name = "type") String type){

		Prodotto prodotto = prodottoService.getArticleByType(type);
		model.addAttribute("articleByType", prodotto);
		return "showArticleByType";
	}

	//Ricerca articolo per nome
	@RequestMapping(value = "researchByName", method = RequestMethod.GET)
	public String searchArticleByName(HttpServletRequest request, Model model){

		return "searchArticleByName";
	}

	//Visulizzazione articolo trovato per name
	@RequestMapping(value = "article_byName", method = RequestMethod.GET)
	public String findArticleByName(HttpServletRequest request, Model model, @RequestParam(name = "name") String name){

		Prodotto prodotto = prodottoService.getArticleByName(name);
		model.addAttribute("articleByName", prodotto);
		return "showArticleByName";
	}
}
