package it.beije.magazzino.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import it.beije.magazzino.model.Shipment;
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
