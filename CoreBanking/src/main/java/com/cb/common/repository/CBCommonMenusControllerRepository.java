package com.cb.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cb.common.constatnt.ICBCommonAPIConstant;
import com.cb.common.entity.CBMenuSectionEntity;

@Repository
public interface CBCommonMenusControllerRepository extends JpaRepository<CBMenuSectionEntity, Integer> {

	//without Native Query
	//@Query(value = "select m from CBMenuSectionEntity m where m.stateCode=:moduleId and  m.active='Y'")
	
	@Query("select m from CBMenuSectionEntity m join fetch m.sectionDeatails join fetch m.cbLevelMenuDetails where m.stateCode=:moduleId and m.active='"+ICBCommonAPIConstant.ACTIVE+"'")

	List<CBMenuSectionEntity> findMenusByStateAndLevel(@Param("moduleId") int moduleId);

	//with Native Query
	@Query(value ="SELECT M.MENU_ID, M.MENU_NAME, M.ROUTE_PATH,S.SECTION_NAME FROM CB_STATE_MENU_MASTER M JOIN CB_MENU_SECTION_MASTER S ON M.SECTION_ID = S.SECTION_ID WHERE M.MODULE_ID = :moduleId",nativeQuery = true)
	List<Object[]> getMenus(Integer moduleId);



}
