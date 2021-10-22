package com.example.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(Long workerId, int days) {
		
		//return new Payment("Bob", 200.00, days); // retorno feito sem referenciar o projeto hr-worker
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId.toString());
		
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", //URL 
												  Worker.class,                 //Tipo do objeto buscado
												  uriVariables); 				//Parametros
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}

}
