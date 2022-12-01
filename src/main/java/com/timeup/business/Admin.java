package com.timeup.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;
	
    private String nameLogin;
    
    
    public Long getAdminId() {
		return adminId;
	}


	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}


	public String getNameLogin() {
		return nameLogin;
	}


	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	private String passWord;
}
