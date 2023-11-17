package me.dio.santanderapinuvem.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="tb_account")
public class Account implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String number;
	
	private String agency;
	
	// 99999999999,99
	@Column(precision = 13, scale = 2)
	private BigDecimal accountBalance;
	
	@Column(precision = 13, scale = 2)
	private BigDecimal accountLimit;
	
	public Account() {		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getAgency() {
		return agency;
	}
	
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal balance) {
		this.accountBalance = balance;
	}
	
	public BigDecimal getAccountLimit() {
		return accountLimit;
	}
	
	public void setAccountLimit(BigDecimal limit) {
		this.accountLimit = limit;
	}	
	

}
