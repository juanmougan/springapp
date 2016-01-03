/**
 * 
 */
package com.github.juanmougan.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.juanmougan.demo.model.Movement;

/**
 * @author juanma
 *
 */
public interface MovementRepository extends CrudRepository<Movement, Long> {

}
