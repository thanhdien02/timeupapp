package com.timeup.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product_category implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pd_cateId;
	
	private String nameCategory;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	
	private List<Product> products;

	public Long getPd_cateId() {
		return pd_cateId;
	}

	public void setPd_cateId(Long pd_cateId) {
		this.pd_cateId = pd_cateId;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	
}
