package com.example.todoCassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.todoCassandra")
public class TodoCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoCassandraApplication.class, args);
	}

}
