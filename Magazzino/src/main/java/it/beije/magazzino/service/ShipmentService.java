package it.beije.magazzino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
