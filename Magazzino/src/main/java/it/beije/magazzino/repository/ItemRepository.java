package it.beije.magazzino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.magazzino.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM contenuto_spedizione WHERE id_shipment = :id_shipment")//JDBC
	public abstract List<Item> loadListByIdShipment(@Param("id_shipment") Integer id_shipment);
}
