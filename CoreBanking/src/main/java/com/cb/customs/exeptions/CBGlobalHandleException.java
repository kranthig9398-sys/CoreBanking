package com.cb.customs.exeptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cb.common.dto.CBServiceResponseDTO;

@RestControllerAdvice
public class CBGlobalHandleException {

	@ExceptionHandler(CBRequestBodyNotFoundExeption.class)
	public ResponseEntity<CBServiceResponseDTO> handleRequestbodyExeptionController(CBServiceResponseDTO cbServiceResponseDTO){
		CBServiceResponseDTO cbServiceResponse=new CBServiceResponseDTO(cbServiceResponseDTO.getMessage(),cbServiceResponseDTO.getStatus(),cbServiceResponseDTO.getErrorCode(),cbServiceResponseDTO.getErrorMessage(),null);
		return ResponseEntity.badRequest().body(cbServiceResponse);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<CBServiceResponseDTO> handleException(NullPointerException ex) {
		CBServiceResponseDTO cbServiceResponseDTO=new CBServiceResponseDTO ("FAILURE",0,"CBE4004", "Internal Error with "+ex.getMessage(), null);
		return ResponseEntity.badRequest().body(cbServiceResponseDTO);
	}
	
	@ExceptionHandler(CBNoDetailsFoundException.class)
	public ResponseEntity<CBServiceResponseDTO> handleException(CBNoDetailsFoundException ndf) {
		CBServiceResponseDTO cbServiceResponseDTO=new CBServiceResponseDTO ("FAILURE",0,"CBE4001", ndf.getMessage(), null);
		return ResponseEntity.badRequest().body(cbServiceResponseDTO);
	}
	@ExceptionHandler(CBInSufficentFundExeption.class)
	public ResponseEntity<CBServiceResponseDTO> inSufficentFundException(CBInSufficentFundExeption cbInSufficentFundExeption){
		CBServiceResponseDTO cbServiceResponseDTO=new CBServiceResponseDTO("FAILURE",0,"CBE4003", cbInSufficentFundExeption.getMessage(), null);
		return ResponseEntity.badRequest().body(cbServiceResponseDTO);
	}
}
