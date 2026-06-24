package com.cb.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cb.common.entity.CBUserProfileMonitorDetailsEntity;
@Repository
public interface CBUserProfileDetailRepository extends JpaRepository<CBUserProfileMonitorDetailsEntity, String> {
   public CBUserProfileMonitorDetailsEntity findByUserID(String userID);

}
