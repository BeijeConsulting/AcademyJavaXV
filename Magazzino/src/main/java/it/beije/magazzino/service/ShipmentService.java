package it.beije.magazzino.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.magazzino.model.Shipment;
import it.beije.magazzino.repository.ShipmentRepository;

@Service
public class ShipmentService {

	@Autowired
	ShipmentRepository shipmentRepository;
	
	public List<Shipment> listAllShipment(){
		return shipmentRepository.findAll();
	}
	
}
