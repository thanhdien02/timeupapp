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
	private Long pd_specId;
	
	private String color;
	private String use_time;
	private String origin;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Product product;
	
}
