/**
 * 
 */
package com.github.juanmougan.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.juanmougan.demo.model.Account;

/**
 * @author juanma
 *
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

}
