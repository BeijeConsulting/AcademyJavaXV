package it.beije.magazzino.controller;

import it.beije.magazzino.model.Prodotto;
import it.beije.magazzino.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ProdottoControllerRest {

    @Autowired
    ProdottoService prodottoService;

    @GetMapping(value = "/all")
    public List<Prodotto> getArticlesList() { return prodottoService.findAllArticles(); }

    @GetMapping(value = "/byId/{id}")
    public Prodotto getSpecificArticle(@PathVariable Integer id){ return prodottoService.findSpecificArticle(id); }

    @PostMapping(value = "/insertArticle")
    public Prodotto insertNewArticle(@RequestBody Prodotto article){

        Prodotto prodotto = new Prodotto();
        prodotto.setName(article.getName());
        prodotto.setType(article.getType());
        prodotto.setQuantity(article.getQuantity());
        prodotto.setDescription(article.getDescription());

        prodottoService.insert(prodotto);

        return prodotto;
    }

    @PutMapping(value = "/update/{id}")
    public Prodotto updateArticle(@PathVariable Integer id, @RequestBody Prodotto article){

        Prodotto prodotto = prodottoService.findSpecificArticle(id);

        if(!article.getName().isEmpty()) prodotto.setName(article.getName());
        if(!article.getType().isEmpty()) prodotto.setType(article.getType());
        if(!article.getName().isEmpty()) prodotto.setName(article.getName());

        return prodotto;
    }

    @DeleteMapping(value = "/delete/{id}")
    public Prodotto deleteArticle(@PathVariable Integer id){

        Prodotto prodotto = prodottoService.findSpecificArticle(id);
        prodottoService.deleteSpecificArticle(id);

        return prodotto;
    }

    @GetMapping(value = "/search_by_type/{type}")
    public List<Prodotto> searchArticleByType(@PathVariable String type) { return prodottoService.getArticleByType(type); }

    @GetMapping(value = "/search_by_name/{name}")
    public Prodotto searchArticleByName(@PathVariable String name) { return prodottoService.getArticleByName(name); }
}
