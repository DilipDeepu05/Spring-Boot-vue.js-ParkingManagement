package com.restpark.ParkingRest.dao;


import java.util.Date;

import java.util.List;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restpark.ParkingRest.model.Customer;
import com.restpark.ParkingRest.model.Details;


@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	private EntityManager em;
	
	@Autowired
	public CustomerDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Customer> getCustomers() {
		Session s=em.unwrap(Session.class);
		Query<Customer> q=s.createQuery("From Customer",Customer.class);
		List<Customer> ls=q.getResultList();
		return ls;
	}

	@Override
	public Customer findById(int id) {
		Session s=em.unwrap(Session.class);
		Customer c=s.get(Customer.class, id);
		return c;
	}

	@Override
	public void save(Customer c) {
		Session s=em.unwrap(Session.class);
		s.saveOrUpdate(c);
	}

	@Override
	public void delete(int id) {
		Session s=em.unwrap(Session.class);
		Customer c=s.get(Customer.class, id);
		s.delete(c);
	}

	@Override
	public List<Details> getDetails() {
		Session s=em.unwrap(Session.class);
		Query<Details> q=s.createQuery("From Details",Details.class);
		List<Details> ds=q.getResultList();
		return ds;
	}



	@Override
	public Details clockOut(Customer c) {
		Session s=em.unwrap(Session.class);
		c.setLogout(new Date());
		s.save(c);
	Details d=calculate(c.getId());
		c.setLogin(null);
		c.setLogout(null);
		s.save(c);
		return d;
	}

	private Details calculate(int id) {
		Session s=em.unwrap(Session.class);
		Query<Customer> q=s.createQuery("From Customer where id=:customerid",Customer.class);
		q.setParameter("customerid", id);
		Customer c=q.getSingleResult();
		System.out.println(c.getLogin()+" "+c.getLogout());
		String s1[]=c.getLogin().toString().split("[-: ]");
		String s2[]=c.getLogout().toString().split("[-: ]");
		int cost=(int)(Math.round(60*Math.abs((Integer.parseInt(s1[2])-Integer.parseInt(s2[2]))))+
				Math.abs(Math.round(30*(Integer.parseInt(s2[3])-Integer.parseInt(s1[3]))))+
				Math.abs(Math.round(((Integer.parseInt(s2[4])-Integer.parseInt(s1[4])))*0.5)));
		String name=c.getFirstname()+" "+c.getLastname();
		Details d=new Details(name,cost,c.getLogin(),c.getLogout());
		s.save(d);
		return d;
	}

	
}
