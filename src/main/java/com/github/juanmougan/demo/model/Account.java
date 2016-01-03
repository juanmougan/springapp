/**
 * 
 */
package com.github.juanmougan.demo.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author juanma
 *
 */
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private Customer owner;
	
	private BigDecimal balance;
	
	// TODO remove Eager mapping here
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Movement> movements;

	protected Account() {
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public void addMovement(Movement movement) {
		this.movements.add(movement);
		movement.setAccount(this);
	}

}
