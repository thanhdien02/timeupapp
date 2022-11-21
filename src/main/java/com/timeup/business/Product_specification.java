package com.timeup.business;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
public class Product_specification {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long pd_specificationId;
	
	public Long getPd_specId() {
		return pd_specificationId;
	}

	public void setPd_specId(Long pd_specificationId) {
		this.pd_specificationId = pd_specificationId;
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
	
	@OneToOne(mappedBy = "pd_specification")
	private Product product;
	
}
