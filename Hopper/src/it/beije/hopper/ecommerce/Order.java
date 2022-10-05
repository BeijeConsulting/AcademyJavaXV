package it.beije.hopper.ecommerce;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/*
CREATE TABLE `hopper`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
 */

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "datetime")
	private LocalDateTime datetime;

	//totale (item1.price * item1.quantity - item1.promo) + (item2.price * item2.quantity - item2.promo) + ...
	@Column(name = "amount")
	private Double amount;

	@Column(name = "promo")
	private Double promo;

	@Transient
	private List<Item> items;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPromo() {
		return promo;
	}

	public void setPromo(Double promo) {
		this.promo = promo;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", userId : ").append(this.userId)
				.append(", datetime : ").append(this.datetime)
				.append(", amount : ").append(this.amount)
				.append(", promo : ").append(this.promo)
				.append(", items : ").append(this.items)
				.append(" }");
		
		return builder.toString();
	}

}
