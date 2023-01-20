package com.valdir.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.todo.domain.Todo;
import com.valdir.todo.repository.TodoRepository;

@Service
public class DbService {

	@Autowired
	private TodoRepository todoRepository;
	
	public void instanciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Todo t1 = new Todo(null, "Estudar", "Esdudar Spring 2 e angular 11", sdf.parse("10/01/2023") , false);
		
		
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");	
//		Todo t1 = new Todo(null, "Estudar", "Esdudar Spring 2 e angular 11", LocalDateTime.parse("10/01/2023 13:44:55", formatter) , false);
		
		todoRepository.saveAll(Arrays.asList(t1));
		
	}
	 
}
