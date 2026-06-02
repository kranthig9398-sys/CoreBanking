package com.cb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.dto.AuthRequestDTO;
import com.cb.security.jwt.JWTSecurityManager;
@RestController
@RequestMapping("jwttoken")
public class JWTTokenController {

	@Autowired
	private JWTSecurityManager jwtUtil;

	@PostMapping("/logintest")
	public String loginTest(@RequestBody AuthRequestDTO requestDTO) {

		System.out.println("Requested "+requestDTO.getUsername()+","+requestDTO.getPassword());

		if ("admin".equals(requestDTO.getUsername()) && "password".equals(requestDTO.getPassword())) {
			return jwtUtil.generateToken(requestDTO.getUsername());
		} else {
			throw new RuntimeException("Invalid Credentials");
		}
	}

	@PostMapping("/validateToken")
	public String validateToken(@RequestHeader("Authorization") String header) {

		if (header == null || !header.startsWith("Bearer ")) {
			return "Invalid Header";
		}

		String token = header.substring(7);

		System.out.println("Token in controller: " + token);

		return jwtUtil.validateToken(token, "admin") ? "Valid Token": "Invalid Token";
	}
	
	@PostMapping("/validateTokenURL")
	public String validateTokenURLRedirection(@RequestHeader("Authorization") String header) {

		if (header == null || !header.startsWith("Bearer ")) {
			return "redirect:/gbm/error";
		}

		String token = header.substring(7);

		return jwtUtil.validateToken(token, "admin")
				? "redirect:/gbm/success"
						: "redirect:/gbm/error";
	}
}
