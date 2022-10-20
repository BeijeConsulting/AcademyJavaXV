package it.beije.hopper.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.hopper.ecommerce.model.Item;
import it.beije.hopper.ecommerce.model.Order;
import it.beije.hopper.model.User;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	public abstract List<Item> deleteByOrderId(Integer orderId);

}
