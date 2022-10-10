package it.beije.hopper.web;

import jakarta.persistence.*;
@Entity
@Table(name = "order_items")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "name")
	private String name;

	@Column(name = "desc")
	private String desc;

	@Column(name = "price")
	private Double price;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "promo")
	private Double promo;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPromo() {
		return promo;
	}

	public void setPromo(Double promo) {
		this.promo = promo;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", orderId : ").append(this.orderId)
				.append(", productId : ").append(this.productId)
				.append(", name : ").append(this.name)
				.append(", desc : ").append(this.desc)
				.append(", price : ").append(this.price)
				.append(", quantity : ").append(this.quantity)
				.append(", promo : ").append(this.promo)
				.append(" }");
		
		return builder.toString();
	}

}
