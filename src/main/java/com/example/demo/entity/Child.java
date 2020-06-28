package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
//@Table(name = "child")
public class Child implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idchild;

	private String firstname;

	private String lastname;

	private int old;

	private String sexe;

	private String datenaissance;

	private String ville;

	private String description;

	private String adress;
    @Column(name="image_url")
	private String imageUrl;

	@OneToMany(mappedBy = "child")
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Childdonator> childdonators;

	public Child() {
	}

	public Child(Integer idchild, String firstname, String lastname, int old, String sexe, String datenaissance,
			String ville, String description, String adress, String imageUrl, List<Childdonator> childdonators) {
		this.idchild = idchild;
		this.firstname = firstname;
		this.lastname = lastname;
		this.old = old;
		this.sexe = sexe;
		this.datenaissance = datenaissance;
		this.ville = ville;
		this.description = description;
		this.adress = adress;
		this.imageUrl = imageUrl;
		this.childdonators = childdonators;
	}

	public Integer getIdchild() {
		return idchild;
	}

	public void setIdchild(Integer idchild) {
		this.idchild = idchild;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Childdonator> getChilddonators() {
		return childdonators;
	}

	public void setChilddonators(List<Childdonator> childdonators) {
		this.childdonators = childdonators;
	}

}