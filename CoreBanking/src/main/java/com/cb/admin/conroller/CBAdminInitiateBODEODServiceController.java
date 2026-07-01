package com.cb.admin.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.admin.service.CBAdminInitiateBODEODService;
import com.cb.common.dto.CBServiceResponseDTO;
import com.cb.common.dto.CBUserDetailsServiceDTO;

@RestController
@RequestMapping("/cb/common/bodeod")
@CrossOrigin(origins = "http://localhost:4200")
public class CBAdminInitiateBODEODServiceController {
	@Autowired
	private CBAdminInitiateBODEODService branchlevelvalidateService;

	private int count=0;
	@PostMapping("/module/api/validate/bodeod")
	public ResponseEntity<CBServiceResponseDTO> validateCommonBODEODisDone(@RequestBody CBUserDetailsServiceDTO cbUserDetailsServiceDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(branchlevelvalidateService.validateBranchLevelBodEodDoneForTheDay(cbUserDetailsServiceDTO));
	}
	@PostMapping("/module/api/perform/bodeod/entry")
	public ResponseEntity<CBServiceResponseDTO> doAdminModuleBODInitiateProcessController(@RequestBody CBUserDetailsServiceDTO cbUserDetailsServiceDTO) {

		return ResponseEntity.status(HttpStatus.OK).body(branchlevelvalidateService.doAdminLevelSchemeCodeModuleInitiateBODEODService(cbUserDetailsServiceDTO));
	}
	@PostMapping("/module/api/perform/update/eod/entry")
	public ResponseEntity<CBServiceResponseDTO> performUpdateEODSchemeCodeBranchLevelModuleUpdateController(@RequestBody CBUserDetailsServiceDTO cbUserDetailsServiceDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(branchlevelvalidateService.performUpdateEODSchemeCodeBranchLevelModuleUpdate(cbUserDetailsServiceDTO));
	}
}