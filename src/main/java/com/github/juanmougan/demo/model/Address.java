/**
 * 
 */
package com.github.juanmougan.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author juanma
 *
 */
@Entity
@Table(name = "CUSTOMER_ADDRESSS")
public class Address {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	
	private String street;
	
	@Column(name = "ZIP_CODE", length = 10)
	private String zipCode;
	
	private String city;
	
	protected Address() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
