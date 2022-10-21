package it.beije.magazzino.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.magazzino.model.Shipment;
import it.beije.magazzino.service.ShipmentService;

@Controller
public class ShipmentController {
	
	@Autowired
	ShipmentService shipmentService;
	
	//Restituisce la lista di tutte le spedizioni
	@RequestMapping(value = {"/all_shipment"}, method = RequestMethod.GET)
	public String listAllShipment(HttpServletRequest request, Model model) {
		List<Shipment> shipments = shipmentService.listAllShipment();

		if(shipments != null && shipments.size() > 0) {
			model.addAttribute("shipments" , shipments);
		}else {
			model.addAttribute("error" , "Non ci sono spedizioni nel magazzino");
		}

		return "list_shipment"; 
	}
}
