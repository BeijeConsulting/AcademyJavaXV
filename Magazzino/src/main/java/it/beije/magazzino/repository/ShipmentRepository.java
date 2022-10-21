package it.beije.magazzino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer>{

	public abstract List<Shipment> findAll();
	
	
	
}
