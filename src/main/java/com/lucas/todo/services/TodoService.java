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
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo: " + Todo.class.getName()));
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

	public List<Todo> findAll() {
		List<Todo> list = repository.findAll();
		return list;
	}

	public Todo create(Todo obj) {
		obj.setId(null); // Isso porque  na classe de entidade já existe o configurador de id
		return repository.save(obj); //persistindo objeto na base de dados
	}

	public void delete(Integer id) {
		repository.deleteById(id); //deletando objeto na base de dados
		
	}

	public Todo update(Integer id, Todo obj) {
		//Caso o objeto ja exista faca
		Todo newObj = findById(id);
		//Caso nao exista faca
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDesscricao(obj.getDesscricao());
		newObj.setFinalizado(obj.getFinalizado());
		return repository.save(newObj); 
	}
	
	
}
