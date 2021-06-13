package com.lucas.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.lucas.todo.domain.Todo;
import com.lucas.todo.repositories.TodoRepository;

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	
	public Todo findById(Integer id) {
		Optional<Todo> obj = repository.findById(id);
		//Faça busca do objeto com o número do id
		return obj.orElse(null);
		//Caso não encontre o Todo retorne nulo
	}

	public List<Todo> findByOpen() {
		List<Todo> list = repository.findAllOpen();
		return list;
	}

	public List<Todo> findByClose() {
		List<Todo> list = repository.findAllClose();
		return list;
	}
	
	
}
