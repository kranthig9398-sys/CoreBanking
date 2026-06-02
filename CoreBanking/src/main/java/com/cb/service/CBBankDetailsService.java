package com.cb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.email.entities.CBBankDetails;
import com.cb.email.entities.CBBankDetailsEntity;
import com.cb.repository.CBBankDetailsWithSpringJDBCRepository;
import com.cb.repository.CBBankDetailsWithSpringJPARepository;
@Service
public class CBBankDetailsService {

	@Autowired
	private CBBankDetailsWithSpringJDBCRepository cbbankDetailsRepository;
	@Autowired
	private CBBankDetailsWithSpringJPARepository bankDetailsWithSpringJPARepository;
	
	public List<CBBankDetails> getBankDetailsService(){
		return cbbankDetailsRepository.getBankDetailsList();
	}
	
	public List<CBBankDetailsEntity> getAllBankDetailsService(){
		return bankDetailsWithSpringJPARepository.findAll();
	}

	public Optional<CBBankDetailsEntity> getBankDetailsServiceById(int id) {
		return bankDetailsWithSpringJPARepository.findById(id) ;
	}
	
}
