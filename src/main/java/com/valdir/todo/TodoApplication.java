package com.valdir.todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valdir.todo.domain.Todo;
import com.valdir.todo.repository.TodoRepository;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner{

	@Autowired
	private TodoRepository todoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//		
//		Todo t1 = new Todo(null, "Estudar", "Esdudar Spring 2 e angular 11", LocalDateTime.parse("10/01/2023 13:44:55", formatter) , false);
//		//todoRepository.saveAll(Arrays.asList(t1));
//		todoRepository.save(t1);
	}

}
