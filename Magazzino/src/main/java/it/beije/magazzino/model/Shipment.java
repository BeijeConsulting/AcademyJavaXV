package it.beije.magazzino.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "spedizione")
public class Shipment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name = "code")
	private Integer code;

	@Column(name = "consignee")
	private String consignee;

	@Column(name = "address")
	private String address;

	@Column(name = "shipment_date")
	private LocalDate shipmentDate;
	
	@Column(name = "receipt_data")
	private LocalDate receiptData;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public LocalDate getReceiptData() {
		return receiptData;
	}

	public void setReceiptData(LocalDate receiptData) {
		this.receiptData = receiptData;
	}
	
	
	public String toString() {
		return this.id + "-" + this.code + "-" + this.consignee + "-" + this.address + "-" + this.shipmentDate + "-" + this.receiptData;
	}
}
