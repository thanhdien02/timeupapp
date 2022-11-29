package com.timeup.business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

	private Long priceSum;
	
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Order_detail> order_details;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	public List<Order_detail> getOrder_details() {
		return order_details;
	}

	public void setOrder_details(List<Order_detail> order_details) {
		this.order_details = order_details;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private LocalDateTime dateShip;
	
	public LocalDateTime getDateShip() {
		return dateShip;
	}

	public void setDateShip(LocalDateTime dateShip) {
		this.dateShip = dateShip;
	}

	@Lob
	private String note_custumer; 

	public String getNote_custumer() {
		return note_custumer;
	}

	public void setNote_custumer(String note_custumer) {
		this.note_custumer = note_custumer;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(Long priceSum) {
		this.priceSum = priceSum;
	}

	
}
