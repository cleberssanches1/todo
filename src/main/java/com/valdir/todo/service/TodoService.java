package com.valdir.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdir.todo.domain.Todo;
import com.valdir.todo.repository.TodoRepository;
import com.valdir.todo.service.exception.ObjectNotFoundException;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public Todo findById(Integer id) {
		Optional<Todo> op = todoRepository.findById(id);
        return op.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado para o ID: " + id + ", Tipo " + Todo.class.getName()));
	 
	}

	public List<Todo> findAll() {
		List<Todo> op = todoRepository.findAll();
		return op;
	}

	public List<Todo> listOpen() {	 
		return todoRepository.findAllOPen();		 
	}
	
	public List<Todo> listClosed() {	 
		return todoRepository.findAllClosed();		 
	}

	public Todo create(Todo obj) {
		obj.setId(null);
		return todoRepository.save(obj);		
	}

	public void delete(Integer id) {		
		todoRepository.delete(findById(id));
	}

	public Todo update(Todo obj, Integer id) {
		
		Todo todo = findById(id);
		todo.setDataParaFinalizar(obj.getDataParaFinalizar());
		todo.setDescricaoo(obj.getDescricao());
		todo.setFinalizado(obj.isFinalizado());
		todo.setTitulo(obj.getTitulo());
		 
		return todoRepository.save(todo);
	}

}
