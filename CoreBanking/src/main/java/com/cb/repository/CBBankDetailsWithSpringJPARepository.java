package com.cb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cb.email.entities.CBBankDetailsEntity;

public interface CBBankDetailsWithSpringJPARepository extends JpaRepository<CBBankDetailsEntity, Integer>{

}
