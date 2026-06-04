package com.cb.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.customs.exeptions.CBNoDetailsFoundException;
import com.cb.dto.UserDetailsServiceDTO;

@RestController
@RequestMapping("/gbm")
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {

	@GetMapping("/hellllo")
	
	public String hello() {
		return "JWT is working!";
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
	

	//cretaed by amala

	@GetMapping("/report")
	public String getReportDtails() {
		return "Reposrt are working successfully!!!";
	}

	@GetMapping("/downloadpdf")
	public String dounloadPdf() {
		return "PDF downloaded successfully!!!";
	}
}
