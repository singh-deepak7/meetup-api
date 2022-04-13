package com.meetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class MeetupApiApplication {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(MeetupApiApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		String sql = "select count(*) from mysvc.meetup";
		String rows = jdbcTemplate.queryForObject(sql, String.class);
		System.out.println("Number of rows are= " + rows);
		//return String.format("Hello %s!", name);
		return String.format("Number of records! %s", rows);
	}

/*	@Override
	public void run(String... args)  {
		String sql = "select count(*) from mysvc.meetup";
		String rows = jdbcTemplate.queryForObject(sql, String.class);
		System.out.println("Number of rows are= " + rows);
	}*/

}
