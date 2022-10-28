package com.example.relationaldataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class RelationalDataAccessApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(RelationalDataAccessApplication.class);

	public static void main(String args[]) {
		SpringApplication.run(RelationalDataAccessApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {

		log.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

		// Split up the array of whole names into an array of first/last names
		List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
				.map(name -> name.split(" ")).collect(Collectors.toList());

		// Use a Java 8 stream to print out each tuple of the list
		splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

		// Uses JdbcTemplate's batchUpdate operation to bulk load data
		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

		log.info("Querying for customer records where first_name = 'Josh':");
		jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE first_name = ?",//Primer argumento => sentencia SQL
						   new Object[] { "Josh" },												  //Segundo argumento => ?
						   (rs, rowNum) -> new Customer(rs.getLong("id"), 						  //Tercer argumento => Creamos el objeto 
							       					    rs.getString("first_name"), 
														rs.getString("last_name")
														)
						  ).forEach(customer -> log.info(customer.toString()));// Devuelve una lista y la recorrmos para imprimir.

		// Añadido Alberto Carrera Martín Octubre 2022
		// Ahora todos como se hacía sin stream ni lambdas
		// Añadir en clase Customer.java los métodos getters y setters
		// y también constructor vacío
		//
		log.info("Ahora sin utilizar stream ni lambdas");
		List<Customer> lista = jdbcTemplate.query(
				"SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
				new RowMapper<Customer>() {
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
						Customer customer = new Customer();
						customer.setId(rs.getLong("id"));
						customer.setFirstName(rs.getString("first_name"));
						customer.setLastName(rs.getString("last_name"));
						return customer;
					}

				});
		log.info(lista.toString());
	}
}
