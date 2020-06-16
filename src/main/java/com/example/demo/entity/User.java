package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.enums.Role;
@Entity
@Table(name ="User ")
public class User  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "iduser")
	private Integer iduser;

	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private Role role;
	
	

	/*@JsonIgnore
	  @OneToMany(mappedBy = "user")
	  @JsonIgnore
     private Set<Child> child = new HashSet<>();*/
	//@OneToMany(targetEntity=Enfant.class, mappedBy="Utilisateur",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	//private List<Enfant> enfant = new ArrayList<>();
	


	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getIduser() {
		return iduser;
	}
	public void setIduser(Integer iduser) {
		this.iduser = iduser;
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

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	@Override
	public String toString() {
		return "User []";
	}
	public User() {
		super();
	}
	
	
	


	/*@OneToMany(mappedBy = "utilisateur")
	private Collection<Enfant> Userid;

	public Collection<Enfant> getUserid() {
		return Userid;
	}

	public void setUserid(Collection<Enfant> userid) {
		Userid = userid;
	}*/


}
