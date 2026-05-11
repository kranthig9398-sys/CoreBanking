package com.gbm.twilo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class TwiloWebHookController {

	@PostMapping(
			value = "/whatsapp",
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE
			)
	public ResponseEntity<String> receive(
			@RequestParam("From") String from,
			@RequestParam("Body") String body) {

		// Your business logic here
		String reply = handleMessage(from, body);

		// Twilio expects TwiML (XML)
		String xml =
				"<Response>" +
						"<Message>" + escapeXml(reply) + "</Message>" +
						"</Response>";

		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_XML)
				.body(xml);
	}

	private String handleMessage(String from, String body) {
		body = body == null ? "" : body.trim().toLowerCase();

		if (body.equals("hi") || body.equals("hello")) {
			return "Welcome! Reply with:\n1. BAL\n2. HELP";
		} else if (body.equals("bal")) {
			return "Your balance is ₹10,000";
		} else if (body.equals("help")) {
			return "Contact support at 1800-xxx";
		}
		return "Sorry, I didn’t understand. Type HELP.";
	}

	// Basic XML escape
	private String escapeXml(String s) {
		return s.replace("&","&amp;")
				.replace("<","&lt;")
				.replace(">","&gt;")
				.replace("\"","&quot;")
				.replace("'","&apos;");
	}
}