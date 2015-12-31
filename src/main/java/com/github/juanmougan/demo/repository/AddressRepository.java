/**
 * 
 */
package com.github.juanmougan.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.juanmougan.demo.model.Address;

/**
 * @author juanma
 *
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
	
	List<Address> findByCity(String city);

}
