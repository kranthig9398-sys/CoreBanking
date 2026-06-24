package com.cb.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cb.common.entity.CBAnnoncementDetailsEntity;
import com.cb.common.entity.CBNativeMenuCommonEntity;
@Repository
public interface CBCommonAnnoncementNativeRpository extends JpaRepository<CBAnnoncementDetailsEntity, Integer>{

	@Query(value="select ANNOUNCEMENT_ID,message,is_active from CB_SCROLL_ANNOUNCEMENTS where is_active='Y'",nativeQuery = true)
	public List<Object[]> getAnnoncementDetailsListRepo();
}
