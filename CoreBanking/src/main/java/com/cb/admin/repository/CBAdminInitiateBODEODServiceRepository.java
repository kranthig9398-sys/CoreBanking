package com.cb.admin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cb.admin.entity.CBAdminBodEodSchemeCodeModuleEntity;
@Repository
public interface CBAdminInitiateBODEODServiceRepository extends JpaRepository<CBAdminBodEodSchemeCodeModuleEntity, Integer>{
	//	List<CBCommonBranchLevelBodEodStatusCheckEntity> findBySchemeCodeAndSolIdAndSolDateAndSolLevel(Integer schemeCode,Integer solId,Date solDate,Integer solLevel);
	@Query("FROM CBAdminBodEodSchemeCodeModuleEntity WHERE schemeCode = :schemeCode AND solId = :solId AND solLevel = :solLevel AND FUNCTION('TRUNC', solDate) = FUNCTION('TRUNC', :solDate) ORDER BY id DESC")
	public List<CBAdminBodEodSchemeCodeModuleEntity> findLatestBODEODCheckStatus(@Param("schemeCode") Integer schemeCode,@Param("solId")Integer solId,@Param("solDate") Date solDate,@Param("solLevel") Integer solLevel);
}
