package com.cb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.email.entities.CBBankDetails;
import com.cb.service.CBBankDetailsService;

@RestController
@RequestMapping("/bankdetails")
public class CBBankDetailsController {
	@Autowired
	private CBBankDetailsService bankDetailsService;
	
	@GetMapping("/getallbankslist")
	public List<CBBankDetails> getBankDetails(){
		return bankDetailsService.getBankDetailsService();		
	}

}
