package com.example.demo.dtos;


public class DonateDto {
	
	private String donatorname;
	
	private String donatoremail;
	
	private int total;
	
	private Integer[] idchildren;

	public DonateDto() {
		super();
	}

	public DonateDto(String donatorname, String donatoremail, int total, Integer[] idchildren) {
		super();
		this.donatorname = donatorname;
		this.donatoremail = donatoremail;
		this.total = total;
		this.idchildren = idchildren;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Integer[] getIdchildren() {
		return idchildren;
	}

	public void setIdchildren(Integer[] idchildren) {
		this.idchildren = idchildren;
	}

	
}
