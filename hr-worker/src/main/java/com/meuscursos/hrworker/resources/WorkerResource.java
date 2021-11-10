package com.meuscursos.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuscursos.hrworker.entities.Worker;
import com.meuscursos.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		
		/*Inserindo comando apenas pra forçar um erro. Utilizado para ver o funcionamento do hystrix*/
//		int x = 1;
//		if (x == 1)
//			throw new RuntimeException("Teste");
		
		/*try {
			//utilizando este comando para forçar um erro de TimeOut. Pois por padrão, balanceamento de carga com Ribbon, tem o tempo de 1 segundo (1000L)
			Thread.sleep(3000L); //pausando por 3 segundos, para depois responder a requisição.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		logger.info("PORT = " + env.getProperty("local.server.port") );
		
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}

}
