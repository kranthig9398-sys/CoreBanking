package com.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.email.entities.CBBankDetails;
import com.cb.repository.CBBankDetailsRepository;
@Service
public class CBBankDetailsService {

	@Autowired
	private CBBankDetailsRepository cbbankDetailsRepository;
	
	public List<CBBankDetails> getBankDetailsService(){
		return cbbankDetailsRepository.getBankDetailsList();
	}
	
}
