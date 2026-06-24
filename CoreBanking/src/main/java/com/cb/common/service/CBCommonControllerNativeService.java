package com.cb.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cb.common.dto.CBAnoncementDetailsDTO;
import com.cb.common.dto.CBModuleGroupDTO;
import com.cb.common.dto.CBModuleMenuCommonDTO;
import com.cb.common.repository.CBCommonAnnoncementNativeRpository;
import com.cb.common.repository.CBCommonControllerServiceNativeRepository;
import com.cb.common.repository.CBGroupModuleRepository;

@Service
public class CBCommonControllerNativeService {
	@Autowired
	private CBCommonControllerServiceNativeRepository cbCommonnControllerServiceRepository;
	@Autowired
	private CBGroupModuleRepository repo;
	@Autowired
	private CBCommonAnnoncementNativeRpository AnnoncementRepo;

	@Cacheable(value = "cbModuleMenus")
	public List<CBModuleMenuCommonDTO> getCBModuleMenuListService() {
		List<CBModuleMenuCommonDTO> dtoList=null;
		try {
			List<Object[]> rows = cbCommonnControllerServiceRepository.getCBModuleListMenuRepo();
			dtoList= new ArrayList<>();

			for(Object[] row : rows){

				dtoList.add(
						new CBModuleMenuCommonDTO(
								(String) row[0],
								(String) row[1],
								"Y".equals(row[2].toString()),
								((Number) row[3]).intValue())
						);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	@Cacheable(value = "cbStateTaxMenus")
	public List<CBModuleMenuCommonDTO> getCBStateMenuListService() {
		List<CBModuleMenuCommonDTO> dtoList =null;
		try {
			List<Object[]> rows =cbCommonnControllerServiceRepository.getCBStateListMenuRepo();
			dtoList = new ArrayList<>();		

			for(Object[] row : rows){

				dtoList.add(
						new CBModuleMenuCommonDTO(
								(String) row[0],
								(String) row[1],
								"Y".equals(row[2].toString()),
								((Number) row[3]).intValue())
						);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	@Cacheable(value = "cbStateCodeSubMenus")
	public List<CBModuleMenuCommonDTO> getStateCodeSubMenuListService() {
		List<CBModuleMenuCommonDTO> dtoList =null;
		try {
			List<Object[]> rows =cbCommonnControllerServiceRepository.getStateCodeSubMenuListRepo();
			dtoList = new ArrayList<>();

			for(Object[] row : rows){

				dtoList.add(
						new CBModuleMenuCommonDTO(
								(String) row[0],
								(String) row[1],
								"Y".equals(row[2].toString()),
								((Number) row[3]).intValue()
								)
						);
			}
		}catch (Exception e) {
			e.printStackTrace();		}
		return dtoList;
	}
	@Cacheable(value = "cbMenuModuleGroupList")
	public List<CBModuleGroupDTO> getAllGroups(){
		return repo.findByActiveOrderByGroupId("Y")
				.stream()
				.map(group -> {

					CBModuleGroupDTO dto =new CBModuleGroupDTO();

					dto.setGroupId(group.getGroupId());
					dto.setGroupName(group.getGroupName());
					return dto;

				}).collect(Collectors.toList());
	}

	@Cacheable(value = "cbGroupIdModuleMenus")
	public List<CBModuleMenuCommonDTO> getCBModuleMenuListBasedOnGroupIdService(int groupId) {
		List<CBModuleMenuCommonDTO> dtoList=null;
		try {
			List<Object[]> rows = cbCommonnControllerServiceRepository.getCBModuleListMenuBasedOnGroupIdRepo(groupId);
			dtoList = new ArrayList<>();

			for(Object[] row : rows){
				dtoList.add(new CBModuleMenuCommonDTO(
						(String) row[0],
						(String) row[1],
						"Y".equals(row[2].toString()),
						((Number) row[3]).intValue())
						);
			}
		}catch (Exception e) {
			e.printStackTrace();		
		}
		return dtoList;
	}

	public List<CBAnoncementDetailsDTO> getAnnoncementDetailsList(){
		List<CBAnoncementDetailsDTO> dtoList=null;
		try {
			List<Object[]> rows = AnnoncementRepo.getAnnoncementDetailsListRepo();
			dtoList = new ArrayList<>();

			for (Object[] row:rows) {
				CBAnoncementDetailsDTO dtodetailsList=new CBAnoncementDetailsDTO();
				dtodetailsList.setId(((Number) row[0]).intValue());
				dtodetailsList.setMessage((String) row[1]);
				dtodetailsList.setActive("Y".equals(row[2].toString()));
				dtoList.add(dtodetailsList);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
}
