package com.timeup.business;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Product_specification implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long pd_specificationId;
	
	public Long getPd_specificationId() {
		return pd_specificationId;
	}

	public void setPd_specificationId(Long pd_specificationId) {
		this.pd_specificationId = pd_specificationId;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}



	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUse_time() {
		return use_time;
	}

	public void setUse_time(String use_time) {
		this.use_time = use_time;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	private String color;
	private String use_time;
	private String origin;
	@Lob
	private String desciption;
	
	private String sizeGreen;
	
	public String getSizeGreen() {
		return sizeGreen;
	}

	public void setSizeGreen(String sizeGreen) {
		this.sizeGreen = sizeGreen;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	private String weight;
	
	@OneToOne(mappedBy = "pd_specification")
	private Product product;
	
}
