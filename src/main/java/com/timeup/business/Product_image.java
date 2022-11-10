package com.timeup.business;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product_image implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pdImgId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Product product;
	@Column(unique=true, nullable = false)
	
	private String image_path;
	public Long getPdImgId() {
		return pdImgId;
	}
	public void setPdImgId(Long pdImgId) {
		this.pdImgId = pdImgId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
}
