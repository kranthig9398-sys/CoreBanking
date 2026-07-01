package com.cb.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cb.common.dto.CBMenuSectionDTO;
import com.cb.common.dto.CBMenusDetailsDTO;
import com.cb.common.dto.CBMenusFInalResponseDTO;
import com.cb.common.entity.CBMenuSectionEntity;
import com.cb.common.repository.CBCommonMenusControllerRepository;
import com.cb.common.service.interfaces.CBMenuCommonStateModuleServiceInterface;
@Service
public class CBMenuCommonStateModuleService implements CBMenuCommonStateModuleServiceInterface {
	@Autowired
	private CBCommonMenusControllerRepository menusRepo;

	@Override
	@Cacheable("stateMenus")
	public CBMenusFInalResponseDTO getCommonStateModuleMenus(int stateCode, int loginLevel) {

		List<CBMenuSectionEntity> entityList = menusRepo.findMenusByStateAndLevel(stateCode);

		Map<Integer, List<CBMenuSectionEntity>> groupId =entityList.stream().collect(Collectors.groupingBy(CBMenuSectionEntity::getSectionId));

		List<CBMenuSectionDTO> sectionList = new ArrayList<>();

		groupId.forEach((section, menus)->{

			CBMenuSectionDTO sectionDTO = new CBMenuSectionDTO();

			sectionDTO.setSectionId(section);

			List<CBMenusDetailsDTO> menuDTOs =menus.stream().map(m -> {

				CBMenusDetailsDTO dto = new CBMenusDetailsDTO();

				dto.setMenuName(m.getMenuName());

				dto.setRoute(m.getRoute());
				sectionDTO.setSectionName(m.getSectionDeatails().getSectionName());
				dto.setAccessLevel(m.getCbLevelMenuDetails().getLevelName());
				dto.setAccessLevelCode(m.getCbLevelMenuDetails().getLevelId());
				return dto;

			}).collect(Collectors.toList());

			sectionDTO.setMenus(menuDTOs);

			sectionList.add(sectionDTO);
		});

		CBMenusFInalResponseDTO response = new CBMenusFInalResponseDTO();

		response.setStateCode(stateCode);

		response.setLoginLevel(loginLevel);
		System.out.println("sectionList->>>>>> "+sectionList);
		response.setSections(sectionList);

		return response;
	}
}