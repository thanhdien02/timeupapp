package com.timeup.business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Import_Product implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long importId;
	
	
	@ManyToOne
	@JoinColumn(name = "providerId")
	private Provider provider;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	public Long getImportId() {
		return importId;
	}

	public void setImportId(Long importId) {
		this.importId = importId;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}



	// Date nhập

	private LocalDateTime date_import;

	public LocalDateTime getDate_import() {
		return date_import;
	}

	public void setDate_import(LocalDateTime date_import) {
		this.date_import = date_import;
	}
	
}
