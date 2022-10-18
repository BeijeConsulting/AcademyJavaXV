package it.beije.hopper.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import it.beije.hopper.model.Item;

/*
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `promo` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_fk_idx` (`user_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB
 */

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@JsonProperty(value = "user_id")
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "datetime")
	private LocalDateTime datetime;

	//totale (item1.price * item1.quantity - item1.promo) + (item2.price * item2.quantity - item2.promo) + ...
	@Column(name = "amount")
	private Double amount;

	@Column(name = "promo")
	private Double promo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
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

	@JsonGetter(value = "datetime")
	public String getDatetimeAsString() {
		return datetime.format(DateTimeFormatter.BASIC_ISO_DATE);
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	@JsonSetter(value = "datetime")
	public void setDatetime(String datetime) {
		this.datetime = LocalDateTime.parse(datetime, DateTimeFormatter.BASIC_ISO_DATE);
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
	
	@JsonGetter(value = "order_code")
	public String getOrderCode() {
		return "BJ-" + this.id;
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
