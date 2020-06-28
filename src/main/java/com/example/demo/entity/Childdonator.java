package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "childdonator")
public class Childdonator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne()
	@JoinColumn(name = "iddonate")
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private User donate;

	@ManyToOne()
	@JoinColumn(name = "idchild")
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Child child;
	
	private int total;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getDonate() {
		return donate;
	}

	public void setDonate(User donate) {
		this.donate = donate;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Childdonator() {
		super();
	}

	public Childdonator(Integer id, User donate, Child child, int total) {
		super();
		this.id = id;
		this.donate = donate;
		this.child = child;
		this.total = total;
	}

}
