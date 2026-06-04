package com.cb.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.customs.exeptions.CBNoDetailsFoundException;
import com.cb.dto.CBServiceResponseDTO;
import com.cb.dto.UserDetailsServiceDTO;

@RestController
@RequestMapping("/cbuser")
@CrossOrigin(origins = "http://localhost:4200")
public class CBUserDetailsController {
	
	@PostMapping("/validateuser")
	public ResponseEntity<CBServiceResponseDTO> validateUser(@RequestBody UserDetailsServiceDTO detailsServiceDTO){
		System.out.println(detailsServiceDTO.toString());
		
		if ("admin".equals(detailsServiceDTO.getUserId())
				&& "admin123".equals(detailsServiceDTO.getPassword())) {
			CBServiceResponseDTO CBServiceResponseDTO=new CBServiceResponseDTO();
			CBServiceResponseDTO.setStatus(0);
			CBServiceResponseDTO.setMessage("SUCCESS");
			return ResponseEntity.ok(CBServiceResponseDTO);
		}

		throw new  CBNoDetailsFoundException("No Details Found for given Invalid Login Credentials");
	}
	
	@PostMapping("/hello")
	public String login(@RequestBody UserDetailsServiceDTO request) {

		System.out.println(request.toString());

		if ("admin".equals(request.getUserId())
				&& "admin123".equals(request.getPassword())) {
			return "SUCCESS";
		}

		throw new  CBNoDetailsFoundException("No Details Found for given Invalid Login Credentials");
	}
	
	@PostMapping("/hello11")
	public String login() {

	    org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	    System.out.println("Username from header: " + auth.getName());

	    if (auth != null && auth.isAuthenticated()) {
	        return "SUCCESS";
	    }

	    throw new CBNoDetailsFoundException("Unauthorized");
	}
}
