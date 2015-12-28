package com.github.juanmougan.demo.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author juanma
 *
 */
@Entity
public class Customer {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	@Embedded
	private PersonalData personalData = new PersonalData();
	
	private List<Address> addresses;
	
	protected Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.personalData.setFirstName(firstName);
		this.personalData.setLastName(lastName);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return personalData.getFirstName();
	}

	public void setFirstName(String firstName) {
		this.personalData.setFirstName(firstName);
	}

	public String getLastName() {
		return personalData.getLastName();
	}

	public void setLastName(String lastName) {
		this.personalData.setLastName(lastName);
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void addAddress(Address address) {
		this.addresses.add(address);
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", this.getId(),
				personalData.getFirstName(), personalData.getLastName());
	}

}
