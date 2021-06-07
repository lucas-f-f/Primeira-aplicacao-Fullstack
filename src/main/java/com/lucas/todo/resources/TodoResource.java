package com.lucas.todo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.todo.domain.Todo;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(PathVariable Integer id) {
		
	}
}
