/**
 * 
 */
package com.github.juanmougan.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.juanmougan.demo.model.Customer;

/**
 * @author juanma
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
