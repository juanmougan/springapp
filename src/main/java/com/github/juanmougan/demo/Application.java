package com.github.juanmougan.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.juanmougan.demo.model.Address;
import com.github.juanmougan.demo.model.Customer;
import com.github.juanmougan.demo.repository.AddressRepository;
import com.github.juanmougan.demo.repository.CustomerRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository, AddressRepository addressRepository) {
		return (args) -> {
			// save a couple of customers
			customerRepository.save(new Customer("Jack", "Bauer"));
			customerRepository.save(new Customer("Chloe", "O'Brian"));
			customerRepository.save(new Customer("Kim", "Bauer"));
			customerRepository.save(new Customer("David", "Palmer"));
			customerRepository.save(new Customer("Michelle", "Dessler"));

			// Fancier customer - has one address
			Customer president = new Customer("President", "Palmer");
			president.addAddress(new Address("1600 Pennsylvania Ave.", "DC20500", "Washington DC"));
			customerRepository.save(president);

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customerRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = customerRepository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch addresses by city
			log.info("Addresses found with findByCity('Washington DC'):");
			log.info("--------------------------------------------");
			for (Address address : addressRepository.findByCity("Washington DC")) {
				log.info(address.toString());
			}
			log.info("");
		};
	}

}