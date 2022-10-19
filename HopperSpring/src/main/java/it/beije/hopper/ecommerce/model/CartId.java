package it.beije.hopper.ecommerce.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartId implements Serializable{

	@Column(name = "id_user")
	private Integer id_user;
	
	@Column(name = "id_product")
    private Integer id_product;
    
	public CartId() {
    }
	
	public CartId(Integer id_user, Integer id_product) {
        this.id_user = id_user;
        this.id_product = id_product;
    }
    
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	public Integer getId_product() {
		return id_product;
	}
	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}
}
