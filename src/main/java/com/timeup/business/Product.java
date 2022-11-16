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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
	
	@Column(name = "nameProduct", columnDefinition = "VARCHAR(500) NOT NULL")
	private String nameProduct;
	
	@ManyToOne
	@JoinColumn(name = "pd_cateId")
	private Product_category pd_category;
	
	private Long price;
	
	@OneToOne
	@JoinColumn(name = "pd_specificationId")
	private Product_specification pd_specification;
	
	private Long number_remain;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Product_image> products_image;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Product_category getPd_category() {
		return pd_category;
	}

	public void setPd_category(Product_category pd_category) {
		this.pd_category = pd_category;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Product_specification getPd_specification() {
		return pd_specification;
	}

	public void setPd_specification(Product_specification pd_specification) {
		this.pd_specification = pd_specification;
	}

	public Long getNumber_remain() {
		return number_remain;
	}

	public void setNumber_remain(Long number_remain) {
		this.number_remain = number_remain;
	}

	public List<Product_image> getProducts_image() {
		return products_image;
	}

	public void setProducts_image(List<Product_image> products_image) {
		this.products_image = products_image;
	}

	
	
}
