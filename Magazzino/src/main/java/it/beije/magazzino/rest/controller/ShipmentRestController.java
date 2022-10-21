package it.beije.magazzino.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.magazzino.model.Product;
import it.beije.magazzino.model.Shipment;
import it.beije.magazzino.repository.ShipmentRepository;
import it.beije.magazzino.service.ShipmentService;

@RestController
@RequestMapping(value = "api")
public class ShipmentRestController {

	@Autowired
	ShipmentService shipmentService;
	

	
	//Lista dei prodotti
		@GetMapping(value = "/all_shipment")
		public List<Shipment> allProducts() {	
			return shipmentService.listAllShipment()		;
		}
		
	
}
