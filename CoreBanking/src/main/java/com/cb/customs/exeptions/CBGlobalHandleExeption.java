package com.cb.customs.exeptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cb.dto.CBServiceResponseDTO;

@RestControllerAdvice
public class CBGlobalHandleExeption {

	@ExceptionHandler(CBRequestBodyNotFoundExeption.class)
	public ResponseEntity<CBServiceResponseDTO> handleRequestbodyExeptionController(CBServiceResponseDTO cbServiceResponseDTO){
		CBServiceResponseDTO cbServiceResponse=new CBServiceResponseDTO(cbServiceResponseDTO.getStatus(),cbServiceResponseDTO.getMessage(),null);
	return ResponseEntity.badRequest().body(cbServiceResponse);

	}

}
