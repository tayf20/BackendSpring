package com.example.demo.dtos;

public class DonateDto {

	private int id;

	private String donatorname;

	private String donatoremail;

	public DonateDto() {
		super();
	}

	public DonateDto(int id, String donatorname, String donatoremail) {

		this.id = id;
		this.donatorname = donatorname;
		this.donatoremail = donatoremail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
