package com.cb.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cb.common.entity.CBUserDetailsEntity;
@Repository
public interface CBUserDetailsWithSpringJPARepository extends JpaRepository<CBUserDetailsEntity, Integer>{
	@Query(value="select count(1) from cb_user_details_master where user_id=:user_id and user_password=:user_password and is_active='Y'",nativeQuery = true)
	public int validateUserLoginCredentials(@Param("user_id") int iUserName, @Param("user_password") String sPassword);
	
	public CBUserDetailsEntity findByUserIdAndIsActive(Integer userId,String isActive);
	
	
}
