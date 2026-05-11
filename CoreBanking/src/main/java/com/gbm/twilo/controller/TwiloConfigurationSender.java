package com.gbm.twilo.controller;

import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbm.security.jwt.TwiloService;

	@RestController
	@RequestMapping("/api/whatsapp")
	public class TwiloConfigurationSender {

	    private final TwiloService service;

	    public TwiloConfigurationSender(TwiloService service) {
	        this.service = service;
	    }

	    @PostMapping("/send")
	    public ResponseEntity<?> send(@RequestBody SendRequest req) {
	        String sid = service.sendMessage(req.getTo(), req.getMessage());
	        return ResponseEntity.ok().body("{\"status\":\"SENT\",\"sid\":\"" + sid + "\"}");
	    }

	    public static class SendRequest {
	        @NotBlank private String to;      // "+91XXXXXXXXXX"
	        @NotBlank private String message;

	        public String getTo() { return to; }
	        public void setTo(String to) { this.to = to; }
	        public String getMessage() { return message; }
	        public void setMessage(String message) { this.message = message; }
	    }
	}