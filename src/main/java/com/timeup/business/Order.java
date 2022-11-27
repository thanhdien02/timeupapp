package com.timeup.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@Temporal(TemporalType.DATE)
	private Date dateShip;

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

	public Date getDateShip() {
		return dateShip;
	}
	
	public void setDateShip(Date dateShip) {
		this.dateShip = dateShip;
	}
	
}
