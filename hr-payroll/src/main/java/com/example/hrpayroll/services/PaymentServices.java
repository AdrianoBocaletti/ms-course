package com.example.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.example.hrpayroll.entities.Payment;

@Service
public class PaymentServices {
	
	public Payment getPayment(Long workerId, int days) {
		return new Payment("Bob", 200.00, days);
	}

}
