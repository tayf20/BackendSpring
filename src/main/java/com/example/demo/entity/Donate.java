package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Table(name ="donate ")
public class Donate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddonate;

	private String donatorname;

	private String donatoremail;

//    @JoinColumn(name = "idchild", nullable = false)

//	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "donate")
//    private List<Child> children=new ArrayList<>();

	

	@OneToOne(fetch = FetchType.LAZY,mappedBy = "donate")
	private Payment payment;

	public Integer getIddonate() {
		return iddonate;
	}

	public void setIddonate(Integer iddonate) {
		this.iddonate = iddonate;
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

	

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/*public Donate(Integer iddonate, int total, String donatorname, String donatoremail,
			List<Childdonator> childdonators, Payment payment) {
		super();
		this.iddonate = iddonate;
		this.total = total;
		this.donatorname = donatorname;
		this.donatoremail = donatoremail;
		this.childdonators = childdonators;
		this.payment = payment;
	}*/
	

}
