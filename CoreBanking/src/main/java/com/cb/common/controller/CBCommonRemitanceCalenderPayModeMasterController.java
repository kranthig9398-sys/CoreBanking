package com.cb.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cb.common.service.CBCommonCalenderPayModeMasterPayloadListService;

@Controller
@RequestMapping("/cb/remitance/calender")
public class CBCommonRemitanceCalenderPayModeMasterController {
	@Autowired
	private CBCommonCalenderPayModeMasterPayloadListService cbCommonPayloadListService;

	@GetMapping("/getcbpaymodelist")
	public String getPaymodeList() {
		cbCommonPayloadListService.getRemitanceCalenderPaymodeListService();
		return null;		
	}
}
