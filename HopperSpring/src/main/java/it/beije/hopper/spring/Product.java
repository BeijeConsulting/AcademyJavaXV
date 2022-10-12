package it.beije.hopper.spring;

/*
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `desc` varchar(2000) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `rating` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB
 */

public class Product {

	private String name;
	private String desc;
	private Double price;
	private Integer quantity;
	private Integer rating;

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

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder().append("{ id : ").append(", name : ")
				.append(this.name).append(", desc : ").append(this.desc).append(", price : ").append(this.price)
				.append(", quantity : ").append(this.quantity).append(", rating : ").append(this.rating).append(" }");

		return builder.toString();
	}
}
