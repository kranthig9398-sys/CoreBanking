package com.cb.common.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.common.dto.CBMenuCommonDTO;

@RestController
@RequestMapping("cb/common")
@CrossOrigin(origins = "http://localhost:4200")
public class CBCommonController {

	@GetMapping("/menu_names")
	public List<CBMenuCommonDTO> getMenu() {

	    return Arrays.asList(
	            new CBMenuCommonDTO("Admin", "/admin", true),
	            new CBMenuCommonDTO("GST 2.0", "/gst", true),
	            new CBMenuCommonDTO("TIN 2.0", "/statetax", true),
	            new CBMenuCommonDTO("ICEGATE", "/icegate", true),
	            new CBMenuCommonDTO("StateTax", "/statetax", true),
	            new CBMenuCommonDTO("Reports", "/report", true)
	    );
	}

}
