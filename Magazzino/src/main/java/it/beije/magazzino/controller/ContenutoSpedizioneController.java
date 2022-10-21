package it.beije.magazzino.controller;

import org.springframework.stereotype.Controller;

//CREATE TABLE `magazzino`.`contenuto_spedizione` (
//		  `id` INT NOT NULL AUTO_INCREMENT,
//		  `spedizione_id` INT NOT NULL,
//		  `prodotto_id` INT NOT NULL,
//		  `quantita` INT NOT NULL,
//		  PRIMARY KEY (`id`),
//		  INDEX `fk_spedizione_id_idx` (`spedizione_id` ASC) VISIBLE,
//		  INDEX `fk_prodotto_id_idx` (`prodotto_id` ASC) VISIBLE,
//		  CONSTRAINT `fk_spedizione_id`
//		    FOREIGN KEY (`spedizione_id`)
//		    REFERENCES `magazzino`.`spedizione` (`id`)
//		    ON DELETE NO ACTION
//		    ON UPDATE NO ACTION,
//		  CONSTRAINT `fk_prodotto_id`
//		    FOREIGN KEY (`prodotto_id`)
//		    REFERENCES `magazzino`.`prodotto` (`id`)
//		    ON DELETE NO ACTION
//		    ON UPDATE NO ACTION);

@Controller
public class ContenutoSpedizioneController {

}
