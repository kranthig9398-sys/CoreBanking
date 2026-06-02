package com.cb.email.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.customs.exeptions.CBRequestBodyNotFoundExeption;
import com.cb.email.entities.CBEmailServiceEntity;

@RestController
@RequestMapping("/cbemail")
public class CBEmailIntegrationServiceController {
	private CBEmailServiceEntity cbEmailserviceEntity=null;
	public ResponseEntity<CBEmailServiceEntity> cbEmaiController(CBEmailServiceEntity cbmailDTO){
		try {
			cbEmailserviceEntity=new CBEmailServiceEntity();


		}catch (CBRequestBodyNotFoundExeption rbnf) {
			throw new CBRequestBodyNotFoundExeption(rbnf.getMessage());
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cbEmailserviceEntity);
	}


}
