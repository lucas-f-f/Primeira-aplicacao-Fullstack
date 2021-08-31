package com.lucas.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.todo.domain.Todo;
import com.lucas.todo.repositories.TodoRepository;

@Service
public class DBServices {
	@Autowired
	private TodoRepository todoRepository;

	//Metodo para instanciar a base de dados sempre que o metodo for chamado
	public void instanciaBaseDeDados() throws ParseException {

		// Formatar data
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		
				
//		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11", LocalDateTime.parse("25/03/2022 10:40", formatter), false);
//		Todo t2 = new Todo(null, "Ler", "Ler livro de desenvolvimento pessoal", LocalDateTime.parse("22/03/2021 13:40", formatter), true);
//		Todo t3 = new Todo(null, "Exercicios", "Praticar exercicios físicos", LocalDateTime.parse("21/03/2022 10:15", formatter), false);
//		Todo t4 = new Todo(null, "Meditar", "Meditar durante 30 minutos pela manhã", LocalDateTime.parse("27/03/2021 05:40", formatter), true);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11", sdf.parse("25/03/2022"), false);
		Todo t2 = new Todo(null, "Ler", "Ler livro de desenvolvimento pessoal", sdf.parse("22/03/2021"), true);
		Todo t3 = new Todo(null, "Exercicios", "Praticar exercicios físicos", sdf.parse("21/03/2022"), false);
		Todo t4 = new Todo(null, "Meditar", "Meditar durante 30 minutos pela manhã", sdf.parse("27/03/2021"), true);
		
		//Salvando no Repository
		todoRepository.saveAll(Arrays.asList(t1,t2,t3,t4));
	}
}
