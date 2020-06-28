package com.example.demo.dtos;

public class ChildDto {

	private String firstname;

	private String lastname;

	private int old;

	private String sexe;

	private String datenaissance;

	private String ville;

	private String adress;

	private String ImageUrl;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public ChildDto() {
		super();
	}

	public ChildDto(String firstname, String lastname, int old, String sexe, String datenaissance, String ville,
			String adress, String imageUrl) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.old = old;
		this.sexe = sexe;
		this.datenaissance = datenaissance;
		this.ville = ville;
		this.adress = adress;
		ImageUrl = imageUrl;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

}
