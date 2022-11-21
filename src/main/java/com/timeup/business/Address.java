package com.timeup.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Address implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long address_id;
	
	@OneToOne
	@JoinColumn(name = "productId")
	private User user;
	
	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCiTy() {
		return ciTy;
	}

	public void setCiTy(String ciTy) {
		this.ciTy = ciTy;
	}

	public String getDicstrict() {
		return dicstrict;
	}

	public void setDicstrict(String dicstrict) {
		this.dicstrict = dicstrict;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getNumber_Home() {
		return number_Home;
	}

	public void setNumber_Home(String number_Home) {
		this.number_Home = number_Home;
	}

	private String ciTy;
	
	private String dicstrict;
	
	private String ward;
	
	private String number_Home;
	

}
