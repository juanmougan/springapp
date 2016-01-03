package com.github.juanmougan.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

	// TODO remove Eager mapping here
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Address> addresses = new ArrayList<>();

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
		address.setCustomer(this);
	}

	public void removeAddress(Address address) {
		this.addresses.remove(address);
		address.setCustomer(null);
	}

	@Override
	public String toString() {
		String result = String.format("Customer[id=%d, firstName='%s', lastName='%s']", this.getId(),
				personalData.getFirstName(), personalData.getLastName());
		if (addresses != null) {
			for (int i = 0; i < addresses.size(); i++) {
				result = result + ", address[" + i + "]" + addresses.get(i).toString();
			}
		}
		return result;
	}

}
