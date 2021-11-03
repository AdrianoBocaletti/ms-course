package com.example.hrpayroll.services;

/*Imports quando utilizado RestTemplate*/
//import java.util.HashMap;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;
import com.example.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	
// Quando utilizava RestTemplate
//	  @Value("${hr-worker.host}")
// 	  private String workerHost;	
//	  @Autowired
//	  private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	
	public Payment getPayment(Long workerId, int days) {
		
		//return new Payment("Bob", 200.00, days); // retorno feito sem referenciar o projeto hr-worker
		
		/*Utilizando RestTemplate*/
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("id", workerId.toString());
//		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", //URL 
//				  Worker.class,                 //Tipo do objeto buscado
//				  uriVariables); 				//Parametros
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}

}
