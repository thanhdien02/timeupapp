package com.timeup.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Provider implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long providerId;
	
	private String nameProvider;
	
	public Long getProviderId() {
		return providerId;
	}


	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}


	public String getNameProvider() {
		return nameProvider;
	}


	public void setNameProvider(String nameProvider) {
		this.nameProvider = nameProvider;
	}


	public String getNumberPhone() {
		return numberPhone;
	}


	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}


	public List<Import_Product> getImport_products() {
		return import_products;
	}


	public void setImport_products(List<Import_Product> import_products) {
		this.import_products = import_products;
	}


	private String numberPhone;
	

	@OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
	private List<Import_Product> import_products;
}
