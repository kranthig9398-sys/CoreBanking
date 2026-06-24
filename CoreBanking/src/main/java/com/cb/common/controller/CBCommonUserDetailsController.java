package com.cb.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cb.builder.CBUserDetailsBuilder;
import com.cb.common.dto.CBServiceResponseDTO;
import com.cb.common.dto.CBUserDetailsServiceDTO;
import com.cb.common.dto.CBUserProfileMonitorDetailsDTO;
import com.cb.common.service.CBUserDetailsService;
import com.cb.customs.exeptions.CBNoDetailsFoundException;

@RestController
@RequestMapping("/cb/cbuser")
@CrossOrigin(origins = "http://localhost:4200")
public class CBCommonUserDetailsController {
	@Autowired
	private CBUserDetailsService cbUserDetailsService;
	@PostMapping("/validateuser")
	public ResponseEntity<CBServiceResponseDTO> validateUser(@RequestBody CBUserDetailsServiceDTO usercredentioalDetailsServiceDTO){
		System.out.println(usercredentioalDetailsServiceDTO.toString());

		boolean isUserValid=cbUserDetailsService.getValidateUserDetailsService(usercredentioalDetailsServiceDTO);

		if (isUserValid){
			CBUserDetailsBuilder userDetailsServiceDTO=cbUserDetailsService.geUserDetailsService(usercredentioalDetailsServiceDTO);

			CBServiceResponseDTO<CBUserDetailsBuilder> CBServiceResponseDTO=new CBServiceResponseDTO();

			CBServiceResponseDTO.setMessage("SUCCESS");
			CBServiceResponseDTO.setStatus(0);

			CBServiceResponseDTO.setResponseBody(userDetailsServiceDTO);
			return ResponseEntity.ok(CBServiceResponseDTO);
		}

		throw new  CBNoDetailsFoundException("No Details Found for given Invalid Login Credentials");
	}

	@PostMapping("/hello")
	public String login(@RequestBody CBUserDetailsServiceDTO request) {

		System.out.println(request.toString());

		if ("admin".equals(request.getUserId()) && "admin123".equals(request.getPassword())) {
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

	@PostMapping("/user/profile/monitoring")
	public boolean updateUserProfileDetailsController(@RequestBody CBUserProfileMonitorDetailsDTO cbUserProfileDetailsDTO) {
		boolean isBollean=false;
		try {
		System.out.println("updateUserProfileDetailsController -->"+cbUserProfileDetailsDTO.toString());
			isBollean=cbUserDetailsService.getValidateUserTokenKeyFromProfileServiceAndSaveOrUpdateSessionService(cbUserProfileDetailsDTO);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isBollean;
	}
	@GetMapping("/user/profile/validate")
	public boolean validateSession(@RequestParam String userId,@RequestParam String sessionId) {
		boolean isBoolean=false;
		try {
			isBoolean= cbUserDetailsService.validateSession(userId, sessionId);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isBoolean;
	}
}
