package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name ="donate ")
public class Donate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iddonate;
	
	private int total;
	
	private String donatorname;
	
	private String donatoremail;
	
//    @JoinColumn(name = "idchild", nullable = false)

	
	@OneToMany(fetch = FetchType.LAZY)
    private List<Child> children;
	
	 @OneToOne(fetch = FetchType.LAZY,
	           
	            mappedBy = "donate")
	    private Payment payment;
	public Integer getIddonate() {
		return iddonate;
	}

	public void setIddonate(Integer iddonate) {
		this.iddonate = iddonate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getDonatorname() {
		return donatorname;
	}

	public void setDonatorname(String donatorname) {
		this.donatorname = donatorname;
	}



	public String getDonatoremail() {
		return donatoremail;
	}

	public void setDonatoremail(String donatoremail) {
		this.donatoremail = donatoremail;
	}

	

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	public Donate() {
		super();
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	
	
	
}
