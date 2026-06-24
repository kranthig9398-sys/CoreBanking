package com.cb.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cb.common.dto.CBAnoncementDetailsDTO;
import com.cb.common.dto.CBMenusFInalResponseDTO;
import com.cb.common.dto.CBModuleGroupDTO;
import com.cb.common.dto.CBModuleMenuCommonDTO;
import com.cb.common.service.CBCommonControllerNativeService;
import com.cb.common.service.CBMenuCommonStateModuleService;
import com.cb.customs.exeptions.CBInSufficentFundExeption;
import com.cb.dto.TransactionRequestDTO;
import com.cb.dto.TransactionResponseDTO;

@RestController
@RequestMapping("/cb/common")
@CrossOrigin(origins = "http://localhost:4200")
public class CBCommonMenuController {
	@Autowired
	private CBCommonControllerNativeService cbCommonControllerService;
	@Autowired
	private CBMenuCommonStateModuleService cbCommonStateModuleMenuService;

	@GetMapping("/dynamic/module/menus")
	public List<CBModuleMenuCommonDTO> getModuleMenuList(){
		List<CBModuleMenuCommonDTO> getModuleMenuListService=cbCommonControllerService.getCBModuleMenuListService();
		if(!getModuleMenuListService.isEmpty()) {
			return  getModuleMenuListService;
		}else {
			throw new CBInSufficentFundExeption("No Module Menus Return ");
		}
	}

	@GetMapping("/dynamic/state/menus/list")
	public List<CBModuleMenuCommonDTO> getStateListMenuList(){
		List<CBModuleMenuCommonDTO> getStateListMenuListService=cbCommonControllerService.getCBStateMenuListService();
		System.out.println("cbCommonControllerService State List MENUS --"+cbCommonControllerService.toString());
		if(!getStateListMenuListService.isEmpty()) {
			return  getStateListMenuListService;
		}else {
			throw new CBInSufficentFundExeption("No State Menus Return ");
		}
	}
	@GetMapping("/dynamic/statecode/sub/menus/list")
	public List<CBModuleMenuCommonDTO> getStateCodeSubMenuList(){
		List<CBModuleMenuCommonDTO> getStateCodeSubMenuListService=cbCommonControllerService.getStateCodeSubMenuListService();
		if(!getStateCodeSubMenuListService.isEmpty()) {
			return  getStateCodeSubMenuListService;
		}else {
			throw new CBInSufficentFundExeption("No State Menus Return ");
		}
	}
	//Menu with out Native
	@GetMapping("/dynamic/statecode/get/menus/list/{stateCode}/{loginLevel}")
	public CBMenusFInalResponseDTO getStateCodeWiseSubMenuList(@PathVariable Integer stateCode,@PathVariable Integer loginLevel) {
		return  cbCommonStateModuleMenuService.getCommonStateModuleMenus(stateCode,loginLevel);
	}

	//dynamic module loader
	@Autowired
	@GetMapping("/modules/groups")
	public List<CBModuleGroupDTO> getGroups(){
		return cbCommonControllerService.getAllGroups();
	}

	@GetMapping("/get/anoncement/list")
	public List<CBAnoncementDetailsDTO> getAnnaoncementDetailsListController(){
		return cbCommonControllerService.getAnnoncementDetailsList();
	}

	//moule menu with group id
	@GetMapping("/modules/groups/id/{groupId}")
	public List<CBModuleMenuCommonDTO> getModuleMenuListBasedOnGroupId(@PathVariable(value = "groupId") int groupId){
		System.out.println("Path Param = "+groupId);
		List<CBModuleMenuCommonDTO> getModuleMenuListBasedOnGroupIdService=cbCommonControllerService.getCBModuleMenuListBasedOnGroupIdService(groupId);
		System.out.println("cbCommonControllerService MENUS --"+cbCommonControllerService.toString());
		if(!getModuleMenuListBasedOnGroupIdService.isEmpty()) {
			return  getModuleMenuListBasedOnGroupIdService;
		}else {
			throw new CBInSufficentFundExeption("No Module Menus Return ");
		}
	}

	@GetMapping("/transaction/search11/{grnNumber}")
	public String getGrnNumber(@PathParam(value = "grnNumber") String grnNumber) {

		return "{\r\n"
				+ "  \"transactionId\":\"TXN10001\"\r\n"
				+ "}";
	}

	@GetMapping("/transaction/details/{grnNumber}/{transactionId}")
	public String getGrnNumberDetails(@PathParam(value = "grnNumber") String grnNumber,@PathParam(value = "transactionId") String transactionId) {

		return "{\r\n"
				+ "  \"grnNumber\":\"10001\",\r\n"
				+ "  \"transactionId\":\"TXN10001\",\r\n"
				+ "  \"customerName\":\"KRANTHI\",\r\n"
				+ "  \"amount\":\"50000\",\r\n"
				+ "  \"accountNumber\":\"1234567890\",\r\n"
				+ "  \"HOACode\":\"100-202-302-20\"\r\n"
				+ "  \"status\":\"SUCCESS\"\r\n"
				+ "}";
	}

	@GetMapping("/transaction/search/{grn}")
	public Map<String,String> searchTransaction(@PathVariable String grn) {

		String transactionId = "";

		if(grn.startsWith("ABCD")) {
			transactionId = "TXN10001";
		} else if(grn.startsWith("EFGH")) {
			transactionId = "TXN10002";
		}

		Map<String,String> response =    new HashMap<>();

		response.put("transactionId", "TXN10001");

		return response;
	}
	@PostMapping("/transaction/details")
	public TransactionResponseDTO getDetails(@RequestBody TransactionRequestDTO dto) {

		TransactionResponseDTO respnseDTO=new TransactionResponseDTO("GRN10001","TXN20001", "KRANTHI","1234567890","Hyderabad Main Branch","1001","50000","SUCCESS", "07-06-2026","Transaction processed successfully");

		return respnseDTO;

	}
	@PostMapping("/transaction/process")
	public Map<String,String> processTransaction(@RequestBody TransactionRequestDTO dto) {
		System.out.println("Transaction Details along with trasnaction Informantion details as --"+dto);
		Map<String,String> response = new HashMap<>();

		response.put("status", "SUCCESS");
		response.put("message", "Transaction processed successfully");

		return response;

	}
}