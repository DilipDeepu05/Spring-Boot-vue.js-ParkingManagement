package com.restpark.ParkingRest.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="login_time")
	private Date login;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="logout_time")
	private Date logout;

	public Customer(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", login=" + login + ", logout=" + logout + "]";
	}

	public Date getLogin() {
		return login;
	}

	public void setLogin(Date s) {
		this.login = s;
	}

	public Date getLogout() {
		return logout;
	}

	public void setLogout(Date logout) {
		this.logout = logout;
	}

	public Customer(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
}
