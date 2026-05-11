package com.gbm.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class TwiloService {
	@Value("${twilio.whatsapp.from}")
	private String fromNumber;

	public String sendMessage(String toNumber, String text) {
		Message message = Message.creator(
				new PhoneNumber("whatsapp:" + toNumber),  // e.g. +9199...
				new PhoneNumber(fromNumber),
				text
				).create();

		return message.getSid();
	}
}