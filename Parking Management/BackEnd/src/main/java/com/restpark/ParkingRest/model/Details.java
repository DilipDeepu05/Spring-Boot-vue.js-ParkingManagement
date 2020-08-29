package com.restpark.ParkingRest.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="details")
public class Details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="amount")
	private int amount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="login_time")
	private Date login;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="logout_time")
	private Date logout;

	public Date getLogin() {
		return login;
	}

	public void setLogin(Date login) {
		this.login = login;
	}

	public Date getLogout() {
		return logout;
	}

	public void setLogout(Date logout) {
		this.logout = logout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Details [id=" + id + ", name=" + name + ", amount=" + amount + ", login=" + login + ", logout=" + logout
				+ "]";
	}

	public Details(String name, int amount, Date login, Date logout) {
		this.name = name;
		this.amount = amount;
		this.login = login;
		this.logout = logout;
	}

	public Details() {}
}
