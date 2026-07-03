package com.cb.admin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cb.admin.dto.CBAdminBODEODStatusResponseDTO;
import com.cb.admin.entity.CBAdminBodEodSchemeCodeModuleEntity;
import com.cb.admin.repository.CBAdminInitiateBODEODServiceRepository;
import com.cb.common.dto.CBServiceResponseDTO;
import com.cb.common.dto.CBUserDetailsServiceDTO;
@Service
public class CBAdminInitiateBODEODService {
	@Autowired
	private CBAdminInitiateBODEODServiceRepository adminBODEODServiceRepository;

	public CBServiceResponseDTO validateBranchLevelBodEodDoneForTheDay(CBUserDetailsServiceDTO cbUserDetailsServiceDto) {
		CBAdminBODEODStatusResponseDTO bodEODStatusApiResponse = null;
		CBServiceResponseDTO apiServiceResponseDTO=null;
		try {
			bodEODStatusApiResponse =  new CBAdminBODEODStatusResponseDTO();
			apiServiceResponseDTO=new CBServiceResponseDTO();

			int sSchemeCode=cbUserDetailsServiceDto.getSchemeCode();
			int sSolId=cbUserDetailsServiceDto.getSolId();
			int sBranchLevel=cbUserDetailsServiceDto.getLoginLevel();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date todayDate = (Date) sdf.parse(cbUserDetailsServiceDto.getSolDate());

			System.out.println("validateBranchLevelBodEodDoneForTheDay-schemeCode : " + sSchemeCode);
			System.out.println("validateBranchLevelBodEodDoneForTheDay-solId      : " + sSolId);
			System.out.println("validateBranchLevelBodEodDoneForTheDay-solLevel   : " + sBranchLevel);
			System.out.println("validateBranchLevelBodEodDoneForTheDay-solDate    : " + todayDate);

			List<CBAdminBodEodSchemeCodeModuleEntity> entityList = adminBODEODServiceRepository.findLatestBODEODCheckStatus(sSchemeCode, sSolId,todayDate, sBranchLevel);
			System.out.println("EOD BOD entityList Repo is :"+entityList.toString());
			if(entityList == null || entityList.isEmpty()) {

				bodEODStatusApiResponse.setEodDone(false);
				bodEODStatusApiResponse.setBodDone(false);
				bodEODStatusApiResponse.setBodStatus(null);
				bodEODStatusApiResponse.setEodStatus(null);
				bodEODStatusApiResponse.setMessage("BOD/EOD status not initiated for Scheme Code "+sSchemeCode+" the day for Selected Branch SolId "+sBranchLevel);

				apiServiceResponseDTO.setStatus(1);
				apiServiceResponseDTO.setMessage("FAILED");
				apiServiceResponseDTO.setErrorCode("BODEOD001");
				apiServiceResponseDTO.setErrorMessage("BOD/EOD status not initiated for Scheme Code "+sSchemeCode+" the day for Selected Branch SolId "+sBranchLevel);
				apiServiceResponseDTO.setResponseBody(bodEODStatusApiResponse);
				return apiServiceResponseDTO;
			}

			CBAdminBodEodSchemeCodeModuleEntity entity = entityList.get(0);

			String bodStatus =	entity.getBodStatus() == null ? null : entity.getBodStatus();
			String eodStatus =entity.getEodStatus() == null ? null : entity.getEodStatus();

			System.out.println("The Branch SOL ID for :"+sBranchLevel+" BOD Status is --->:"+bodStatus);
			System.out.println("The Branch SOL ID for :"+sBranchLevel+" EOD Status is --->:"+eodStatus);

			bodEODStatusApiResponse.setBodStatus(bodStatus);
			bodEODStatusApiResponse.setEodStatus(eodStatus);

			if (!"C".equalsIgnoreCase(bodStatus)) {

				bodEODStatusApiResponse.setBodDone(false);
				bodEODStatusApiResponse.setMessage("BOD Not completed today for Scheme Code "+sSchemeCode+" the Branch Code "+sBranchLevel);
				apiServiceResponseDTO.setErrorMessage("BOD Not completed today for Scheme Code "+sSchemeCode+" the Branch Code "+sBranchLevel+" kindly initiate");
				apiServiceResponseDTO.setStatus(1);
				apiServiceResponseDTO.setMessage("FAILED");
				apiServiceResponseDTO.setErrorCode("BOD001");
				apiServiceResponseDTO.setResponseBody(bodEODStatusApiResponse);
			}
			if ("C".equalsIgnoreCase(eodStatus)) {

				bodEODStatusApiResponse.setEodDone(false);
				bodEODStatusApiResponse.setMessage("EOD already completed today for Scheme Code "+sSchemeCode+" the Branch "+sBranchLevel+" !link Access Denied");
				apiServiceResponseDTO.setErrorMessage("EOD already completed today for Scheme Code "+sSchemeCode+" the Branch "+sBranchLevel+" !link Access Denied");
				apiServiceResponseDTO.setStatus(1);
				apiServiceResponseDTO.setMessage("FAILED");
				apiServiceResponseDTO.setErrorCode("EOD002");
				apiServiceResponseDTO.setResponseBody(bodEODStatusApiResponse);
			}
			bodEODStatusApiResponse.setBodDone(true);
			bodEODStatusApiResponse.setEodDone(true);
			bodEODStatusApiResponse.setMessage(null);

			return apiServiceResponseDTO;

		} catch (Exception e) {
			bodEODStatusApiResponse.setEodDone(false);
			bodEODStatusApiResponse.setBodDone(false);
			bodEODStatusApiResponse.setMessage("Error while validating BOD/EOD status");
			bodEODStatusApiResponse.setBodStatus(null);
			bodEODStatusApiResponse.setEodStatus(null);
			apiServiceResponseDTO.setErrorMessage("Error while validating BOD/EOD status");

			apiServiceResponseDTO.setStatus(1);
			apiServiceResponseDTO.setMessage("FAILED");
			apiServiceResponseDTO.setErrorCode("BODEOD003");
			apiServiceResponseDTO.setResponseBody(bodEODStatusApiResponse);

			e.printStackTrace();
			return apiServiceResponseDTO;
		}
	}
	public CBServiceResponseDTO validateModuleBranchLevelForTheDaywithActionType(CBUserDetailsServiceDTO cbUserDetailsServiceDto,String sActionType) {
		CBAdminBODEODStatusResponseDTO bodEODStatusApiResponse = null;
		CBServiceResponseDTO apiServiceResponseDTO=null;
		try {
			bodEODStatusApiResponse =  new CBAdminBODEODStatusResponseDTO();
			apiServiceResponseDTO=new CBServiceResponseDTO();

			int sSchemeCode=cbUserDetailsServiceDto.getSchemeCode();
			int sSolId=cbUserDetailsServiceDto.getSolId();
			int sBranchLevel=cbUserDetailsServiceDto.getLoginLevel();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date todayDate = (Date) sdf.parse(cbUserDetailsServiceDto.getSolDate());

			System.out.println("validateModuleBranchLevelForTheDaywithActionType-schemeCode  :" + sSchemeCode);
			System.out.println("validateModuleBranchLevelForTheDaywithActionType-solId       :" + sSolId);
			System.out.println("validateModuleBranchLevelForTheDaywithActionType-solLevel    :" + sBranchLevel);
			System.out.println("validateModuleBranchLevelForTheDaywithActionType-solDate     :" + todayDate);
			System.out.println("validateModuleBranchLevelForTheDaywithActionType-Action Type :" + sActionType);

			if(sBranchLevel==4) {
				List<CBAdminBodEodSchemeCodeModuleEntity> dashboardData =adminBODEODServiceRepository.findBySolIdAndSolDateAndSchemeCodeOrderBySolLevel(sSolId,todayDate,sSchemeCode);
				apiServiceResponseDTO.setStatus(0);
				apiServiceResponseDTO.setMessage("SUCCESS");
				apiServiceResponseDTO.setResponseBody(dashboardData);
				return apiServiceResponseDTO;
			}
			
			List<CBAdminBodEodSchemeCodeModuleEntity> entityList = adminBODEODServiceRepository.findLatestBODEODCheckStatus(sSchemeCode, sSolId,todayDate, sBranchLevel);
			System.out.println("EOD BOD entityList Repo is :"+entityList.toString());
			if(entityList == null || entityList.isEmpty()) {

				apiServiceResponseDTO.setStatus(0);
				apiServiceResponseDTO.setMessage("SUCCESS");
				apiServiceResponseDTO.setErrorCode("BODEOD001");
				apiServiceResponseDTO.setErrorMessage("BOD/EOD status not initiated for Scheme Code "+sSchemeCode+" the day for Selected Branch SolId "+sBranchLevel);
				apiServiceResponseDTO.setResponseBody(null);
				return apiServiceResponseDTO;
			}

			CBAdminBodEodSchemeCodeModuleEntity entity = entityList.get(0);

			String bodStatus =	entity.getBodStatus() == null ? null : entity.getBodStatus();
			String eodStatus =entity.getEodStatus() == null ? null : entity.getEodStatus();

			System.out.println("The Branch SOL ID for :"+sBranchLevel+" BOD Status is --->:"+bodStatus);
			System.out.println("The Branch SOL ID for :"+sBranchLevel+" EOD Status is --->:"+eodStatus);

			bodEODStatusApiResponse.setBodStatus(bodStatus);
			bodEODStatusApiResponse.setEodStatus(eodStatus);

			if(sActionType.equalsIgnoreCase("BOD")) {
				if (!"C".equalsIgnoreCase(bodStatus) || "N".equalsIgnoreCase(bodStatus)) {

					bodEODStatusApiResponse.setBodDone(true);
					bodEODStatusApiResponse.setMessage("BOD Not completed today for Scheme Code "+sSchemeCode+" the Branch Code "+sBranchLevel);
					apiServiceResponseDTO.setErrorMessage("BOD Not completed today for Scheme Code "+sSchemeCode+" the Branch Code "+sBranchLevel);
					apiServiceResponseDTO.setStatus(0);
					apiServiceResponseDTO.setMessage("SUCCESS");
					apiServiceResponseDTO.setErrorCode("BOD001");
					apiServiceResponseDTO.setResponseBody(null);
				}else {

					bodEODStatusApiResponse.setBodDone(true);
					bodEODStatusApiResponse.setMessage("BOD is Completed today for Scheme Code "+sSchemeCode+" the Branch "+sBranchLevel);
					apiServiceResponseDTO.setErrorMessage("BOD is Completed today for Scheme Code "+sSchemeCode+" the Branch "+sBranchLevel);
					apiServiceResponseDTO.setStatus(0);
					apiServiceResponseDTO.setMessage("SUCCESS");
					apiServiceResponseDTO.setErrorCode("BOD002");
					apiServiceResponseDTO.setResponseBody(null);
				}
			}else {

				if (!"C".equalsIgnoreCase(eodStatus) || "N".equalsIgnoreCase(eodStatus)) {

					bodEODStatusApiResponse.setBodDone(true);
					bodEODStatusApiResponse.setMessage("EOD Not completed today for Scheme Code "+sSchemeCode+" the Branch Code "+sBranchLevel);
					apiServiceResponseDTO.setErrorMessage("EOD Not completed today for Scheme Code "+sSchemeCode+" the Branch Code "+sBranchLevel);
					apiServiceResponseDTO.setStatus(1);
					apiServiceResponseDTO.setMessage("FAILED");
					apiServiceResponseDTO.setErrorCode("EOD001");
					apiServiceResponseDTO.setResponseBody(null);
				}else  {
					bodEODStatusApiResponse.setEodDone(true);
					bodEODStatusApiResponse.setMessage("EOD is Completed today for Scheme Code "+sSchemeCode+" the Branch "+sBranchLevel);
					apiServiceResponseDTO.setErrorMessage("EOD is Completed today for Scheme Code "+sSchemeCode+" the Branch "+sBranchLevel);
					apiServiceResponseDTO.setStatus(1);
					apiServiceResponseDTO.setMessage("FAILED");
					apiServiceResponseDTO.setErrorCode("EOD002");
					apiServiceResponseDTO.setResponseBody(null);
				}
			}
			return apiServiceResponseDTO;

		} catch (Exception e) {
			apiServiceResponseDTO.setErrorMessage("Error while validating BOD/EOD status");
			apiServiceResponseDTO.setStatus(1);
			apiServiceResponseDTO.setMessage("FAILED");
			apiServiceResponseDTO.setErrorCode("BODEOD003");
			apiServiceResponseDTO.setResponseBody(null);
			e.printStackTrace();
			return apiServiceResponseDTO;
		}
	}
	//Perform BODEOD Entry
	public CBServiceResponseDTO doAdminLevelSchemeCodeModuleInitiateBODEODService(@RequestBody CBUserDetailsServiceDTO cbUserDetailsServiceDTO) {
		CBServiceResponseDTO cbServiceResponseDTO=null;
		try {
			cbServiceResponseDTO=new CBServiceResponseDTO<>();
			int sSchemeCode=cbUserDetailsServiceDTO.getSchemeCode();
			int sSolId=cbUserDetailsServiceDTO.getSolId();
			int sBranchLevel=cbUserDetailsServiceDTO.getLoginLevel();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date todayDate;
			todayDate = (Date) sdf.parse(cbUserDetailsServiceDTO.getSolDate());

			System.out.println("doAdminLevelSchemeCodeModuleInitiateBODEODService-schemeCode : " + sSchemeCode);
			System.out.println("doAdminLevelSchemeCodeModuleInitiateBODEODService-solId      : " + sSolId);
			System.out.println("doAdminLevelSchemeCodeModuleInitiateBODEODService-solLevel   : " + sBranchLevel);
			System.out.println("doAdminLevelSchemeCodeModuleInitiateBODEODService-solDate    : " + todayDate);

			List<CBAdminBodEodSchemeCodeModuleEntity> entityList = adminBODEODServiceRepository.findLatestBODEODCheckStatus(sSchemeCode, sSolId,todayDate, sBranchLevel);
			System.out.println("EOD BOD entityList Repo is :"+entityList.toString());

			if(entityList == null || entityList.isEmpty()) {
				System.out.println("Initiated call to Performing BODEOD Entity");

				if(!performBodEODSchemeCodeBranchLevelModule(cbUserDetailsServiceDTO)) {
					cbServiceResponseDTO.setStatus(1);
					cbServiceResponseDTO.setMessage("FAILED");
					cbServiceResponseDTO.setErrorCode("ERR004");
					cbServiceResponseDTO.setErrorMessage("Perform BOD Initiation operation Failed try again");
					return cbServiceResponseDTO;
				}else {
					cbServiceResponseDTO.setStatus(0);
					cbServiceResponseDTO.setMessage("SUCCESS");
					cbServiceResponseDTO.setSuccessMessage("BOD Initiation Completed Successfully for the Scheme "+sSchemeCode+ " Branch for "+sSolId);
				}
			}else {
				cbServiceResponseDTO.setStatus(1);
				cbServiceResponseDTO.setMessage("FAILED");
				cbServiceResponseDTO.setErrorCode("ERR008");
				cbServiceResponseDTO.setErrorMessage("BOD Already Completed Successfully! for Scheme Code "+sSchemeCode+" the Branch "+sBranchLevel);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cbServiceResponseDTO;
	}
	//insert BODEOD Entry
	public boolean performBodEODSchemeCodeBranchLevelModule(CBUserDetailsServiceDTO cbUserDetailsServiceDTO) {
		try {
			int sSchemeCode=cbUserDetailsServiceDTO.getSchemeCode();
			int sSolId=cbUserDetailsServiceDTO.getSolId();
			int sBranchLevel=cbUserDetailsServiceDTO.getLoginLevel();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			Date todayDate;
			todayDate = (Date) sdf.parse(cbUserDetailsServiceDTO.getSolDate());

			System.out.println("performBodEODSchemeCodeBranchLevelModule-schemeCode : " + sSchemeCode);
			System.out.println("performBodEODSchemeCodeBranchLevelModule-solId      : " + sSolId);
			System.out.println("performBodEODSchemeCodeBranchLevelModule-solLevel   : " + sBranchLevel);
			System.out.println("performBodEODSchemeCodeBranchLevelModule-solDate    : " + todayDate);

			CBAdminBodEodSchemeCodeModuleEntity insertBodEodSchemeCodeModuleEntity=new CBAdminBodEodSchemeCodeModuleEntity();

			insertBodEodSchemeCodeModuleEntity.setSchemeCode(sSchemeCode);
			insertBodEodSchemeCodeModuleEntity.setSolId(sSolId);
			insertBodEodSchemeCodeModuleEntity.setSolLevel(sBranchLevel);
			insertBodEodSchemeCodeModuleEntity.setSolDate(todayDate);

			insertBodEodSchemeCodeModuleEntity.setBodStatus("C");
			insertBodEodSchemeCodeModuleEntity.setBodDoneBy(cbUserDetailsServiceDTO.getUsername());
			insertBodEodSchemeCodeModuleEntity.setBodDoneDate(new Date());
			insertBodEodSchemeCodeModuleEntity.setEodStatus("N");

			adminBODEODServiceRepository.save(insertBodEodSchemeCodeModuleEntity);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;		
	}

	// Update EOD Entry
	public CBServiceResponseDTO performUpdateEODSchemeCodeBranchLevelModuleUpdate(CBUserDetailsServiceDTO cbUserDetailsServiceDTO) {

		CBServiceResponseDTO cbServiceResponseDTO =null;

		try {
			cbServiceResponseDTO =	new CBServiceResponseDTO();
			int sSchemeCode=cbUserDetailsServiceDTO.getSchemeCode();
			int sSolId=cbUserDetailsServiceDTO.getSolId();
			int sBranchLevel=cbUserDetailsServiceDTO.getLoginLevel();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date todayDate;
			todayDate = (Date) sdf.parse(cbUserDetailsServiceDTO.getSolDate());

			System.out.println("performUpdateEODSchemeCodeBranchLevelModuleUpdate-schemeCode : " + sSchemeCode);
			System.out.println("performUpdateEODSchemeCodeBranchLevelModuleUpdate-solId      : " + sSolId);
			System.out.println("performUpdateEODSchemeCodeBranchLevelModuleUpdate-solLevel   : " + sBranchLevel);
			System.out.println("performUpdateEODSchemeCodeBranchLevelModuleUpdate-solDate    : " + todayDate);

			List<CBAdminBodEodSchemeCodeModuleEntity> list = adminBODEODServiceRepository.findLatestBODEODCheckStatus(sSchemeCode, sSolId,todayDate, sBranchLevel);

			if (!list.isEmpty()) {

				CBAdminBodEodSchemeCodeModuleEntity entity = list.get(0);
				entity.setEodStatus("C");
				entity.setEodDoneBy(cbUserDetailsServiceDTO.getUsername());
				entity.setEodDoneDate(new Date());
				adminBODEODServiceRepository.save(entity);
				cbServiceResponseDTO.setStatus(0);
				cbServiceResponseDTO.setMessage("SUCCESS");
				cbServiceResponseDTO.setSuccessMessage("EOD Initiation Completed Successfully for the Scheme "+sSchemeCode+ " Branch for "+sSolId);				
			}else {
				cbServiceResponseDTO.setStatus(1);
				cbServiceResponseDTO.setMessage("FAILED");
				cbServiceResponseDTO.setErrorCode("ERR006");
				cbServiceResponseDTO.setErrorMessage("EOD Initiate Process Failed ,No BOD/EOD Entry Found,Please Contact Admin");
			}
		} catch (Exception e) {
			cbServiceResponseDTO.setStatus(1);
			cbServiceResponseDTO.setMessage("FAILED");
			cbServiceResponseDTO.setErrorCode("ERR007");
			cbServiceResponseDTO.setErrorMessage(e.getMessage());
		}
		return cbServiceResponseDTO;
	}
}