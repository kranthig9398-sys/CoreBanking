package com.cb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.customs.exeptions.CBNoDetailsFoundException;
import com.cb.email.entities.CBBankDetails;
import com.cb.email.entities.CBBankDetailsEntity;
import com.cb.service.CBBankDetailsService;

@RestController
@RequestMapping("/bankdetails")
public class CBBankDetailsController {
	@Autowired
	private CBBankDetailsService bankDetailsService;
	
	@GetMapping("/getbankslist")
	public List<CBBankDetails> getBankDetails(){
		return bankDetailsService.getBankDetailsService();		
	}
	
	@GetMapping("/getallbankslist")
	public List<CBBankDetailsEntity> getAllBankDetails(){
		return bankDetailsService.getAllBankDetailsService();		
	}

	@GetMapping("/getbankdtlsbyid/{Id}")
	public CBBankDetailsEntity getBankDetailsById(@PathVariable int Id){
		Optional<CBBankDetailsEntity> optional=bankDetailsService.getBankDetailsServiceById(Id);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new CBNoDetailsFoundException("No Details Found for given Id is "+Id);
		}
	}
}
