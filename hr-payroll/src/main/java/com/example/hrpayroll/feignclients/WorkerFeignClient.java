package com.example.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.hrpayroll.entities.Worker;

@Component
//@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers") //Utilizado quando tem apenas uma instancia
@FeignClient(name = "hr-worker", path = "/workers") //Utilizado quando tem várias instancias
public interface WorkerFeignClient {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);

}
