package com.cb.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cb.common.entity.CBModuleGroupEntity;

@Repository
public interface CBGroupModuleRepository extends JpaRepository<CBModuleGroupEntity, Integer> {


	List<CBModuleGroupEntity> findByActiveOrderByGroupId(String active);
	//List<CBModuleGroupEntity> findByByGroupId(int active);
}
