package com.cb.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cb.common.entity.CBNativeMenuCommonEntity;
@Repository
public interface CBCommonControllerServiceNativeRepository extends JpaRepository<CBNativeMenuCommonEntity, Integer>{

	@Query(value="SELECT MODULE_NAME AS menuName, ROUTE_PATH AS route,IS_ACTIVE AS canActive,MODULE_ID AS id FROM CB_MODULE_MASTER WHERE IS_ACTIVE = 'Y' order by MODULE_NAME",nativeQuery = true)
	public List<Object[]> getCBModuleListMenuRepo();
	@Query(value="SELECT State_NAME AS menuName, ROUTE_PATH AS route,IS_ACTIVE AS canActive,state_code AS id FROM CB_STATE_MODULE_MASTER WHERE IS_ACTIVE = 'Y' order by State_NAME",nativeQuery = true)
	public List<Object[]> getCBStateListMenuRepo();
	@Query(value="SELECT MENU_NAME AS MENUNAME, ROUTE_PATH AS ROUTE,IS_ACTIVE AS CANACTIVE,MENU_ID AS ID FROM CB_STATE_MENU_MASTER WHERE IS_ACTIVE = 'Y' order by menu_Name",nativeQuery = true)
	public List<Object[]> getStateCodeSubMenuListRepo();
	@Query(value="SELECT m.MODULE_NAME AS menuName,  m.ROUTE_PATH AS route, m.IS_ACTIVE AS canActive, m.MODULE_ID AS id FROM CB_MODULE_MASTER m,CB_MODULE_GROUP_MASTER mg WHERE  m.IS_ACTIVE = 'Y' and mg.IS_ACTIVE = 'Y'and  m.group_id=mg.group_id and  m.group_id=:groupId  order by MODULE_NAME",nativeQuery = true)
	public List<Object[]> getCBModuleListMenuBasedOnGroupIdRepo( int groupId);

}
