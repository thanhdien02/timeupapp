package com.timeup.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Order_detail implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long order_detail_Id;
	
	private Long price;
	
	private Long number;
	
	public Long getNumber() {
		return number;
	}


	public void setNumber(Long number) {
		this.number = number;
	}


	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
	
	
	public Long getOrder_detail_Id() {
		return order_detail_Id;
	}


	public void setOrder_detail_Id(Long order_detail_Id) {
		this.order_detail_Id = order_detail_Id;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;

}
