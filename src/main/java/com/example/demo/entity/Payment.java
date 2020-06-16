package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name ="payment ")
public class Payment  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idpayment;


	private int creditcard;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iddonate", nullable = false)
    private Donate donate;
	
	public Integer getIdpayment() {
		return idpayment;
	}
	public void setIdpayment(Integer idpayment) {
		this.idpayment = idpayment;
	}
	
	public int getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(int creditcard) {
		this.creditcard = creditcard;
	}
	public Donate getDonate() {
		return donate;
	}
	public void setDonate(Donate donate) {
		this.donate = donate;
	}
	public Payment() {
		super();
	}
	
	
	
	
}
