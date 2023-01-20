package com.valdir.todo.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.valdir.todo.domain.Todo;
import com.valdir.todo.service.TodoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

	@Autowired
	private TodoService todoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(todoService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<Todo>> findAll() {
		return ResponseEntity.ok().body(todoService.findAll());
	}

	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> listOpen() {
		return ResponseEntity.ok().body(todoService.listOpen());
	}

	@GetMapping(value = "/closed")
	public ResponseEntity<List<Todo>> listClosed() {
		return ResponseEntity.ok().body(todoService.listClosed());
	}

	@PostMapping
	public ResponseEntity<Todo> create(@RequestBody Todo obj) {
		obj = todoService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		todoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj) {
		obj = todoService.update(obj, id);		
		return ResponseEntity.ok().body(obj);
	}
	
}
