package com.cb.common.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.builder.CBUserDetailsBuilder;
import com.cb.common.dto.CBUserDetailsServiceDTO;
import com.cb.common.dto.CBUserProfileMonitorDetailsDTO;
import com.cb.common.entity.CBUserDetailsEntity;
import com.cb.common.entity.CBUserProfileMonitorDetailsEntity;
import com.cb.common.repository.CBUserDetailsWithSpringJPARepository;
import com.cb.common.repository.CBUserProfileDetailRepository;

@Service
public class CBUserDetailsService {

	@Autowired
	private CBUserDetailsWithSpringJPARepository userDetailsWithSpringJPARepository;
	@Autowired
	private CBUserProfileDetailRepository userProfileRepository;

	public boolean getValidateUserDetailsService(CBUserDetailsServiceDTO cbUserDetailsServiceDTO) {
		int iuseCount = userDetailsWithSpringJPARepository.validateUserLoginCredentials(cbUserDetailsServiceDTO.getUserId(), cbUserDetailsServiceDTO.getPassword());
		return iuseCount > 0 ? true : false;
	}

	public CBUserDetailsBuilder geUserDetailsService(CBUserDetailsServiceDTO cbUserDetailsServiceDTO) {
		CBUserDetailsEntity entity = userDetailsWithSpringJPARepository.findByUserIdAndIsActive(cbUserDetailsServiceDTO.getUserId(), "Y");

		CBUserDetailsBuilder UserDetailsBuilderdto = new CBUserDetailsBuilder.Builder().userId(entity.getUserId())
				.username(entity.getUsername()).roll(entity.getRoll()).build();

		return UserDetailsBuilderdto;
	}

	public boolean getValidateUserTokenKeyFromProfileServiceAndSaveOrUpdateSessionService(CBUserProfileMonitorDetailsDTO userProfileMonitorDetailsDTO) {
		try {
			System.out.println("the USerId for select Chec-----> :"+userProfileMonitorDetailsDTO.getUserID());
			CBUserProfileMonitorDetailsEntity userProfileMonitorDetailsEntity = userProfileRepository.findByUserID(userProfileMonitorDetailsDTO.getUserID());

			if (userProfileMonitorDetailsEntity == null) {

				userProfileMonitorDetailsEntity = new CBUserProfileMonitorDetailsEntity();

				BeanUtils.copyProperties(userProfileMonitorDetailsDTO, userProfileMonitorDetailsEntity);

				userProfileRepository.save(userProfileMonitorDetailsEntity);

				return true;
			}

			userProfileMonitorDetailsEntity.setSessionId(userProfileMonitorDetailsDTO.getSessionId());
			userProfileMonitorDetailsEntity.setIpAddress(userProfileMonitorDetailsDTO.getIpAddress());
			userProfileMonitorDetailsEntity.setUserKey(userProfileMonitorDetailsDTO.getUserKey());
			userProfileMonitorDetailsEntity.setUserLoginLevel(userProfileMonitorDetailsDTO.getUserLoginLevel());
			userProfileMonitorDetailsEntity.setSolId(userProfileMonitorDetailsDTO.getSolId());

			userProfileRepository.save(userProfileMonitorDetailsEntity);	
		}
			catch(Exception e) {
				System.out.println();
				return false;
			}
			return true;
		}

		public boolean validateSession(String userId, String sessionId) {

			CBUserProfileMonitorDetailsEntity entity = userProfileRepository.findByUserID(userId);

			if (entity == null) {
				return false;
			}

			return sessionId.equals(entity.getSessionId());
		}
	}
