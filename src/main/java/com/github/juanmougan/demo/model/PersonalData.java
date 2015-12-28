package com.github.juanmougan.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class PersonalData {

	private String firstName;
	private String lastName;

	public PersonalData() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}