package com.cb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cb.email.entities.CBBankDetails;

@Repository
public class CBBankDetailsRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<CBBankDetails> getBankDetailsList(){
		String QSELECT_BANK_QUERY="SELECT BANK_ID,BNAME,BLOCATION,PERENT_SOL,NODAL_SOL FROM BANKDETAILS";
		
		 return jdbcTemplate.query(
				 QSELECT_BANK_QUERY,
	                (rs, rowNum) -> {
	                	CBBankDetails cbBankDetails=new CBBankDetails(rs.getInt("BANK_ID"), rs.getString("BNAME"), rs.getString("BLOCATION"), rs.getString("PERENT_SOL"), rs.getString("NODAL_SOL"));      	
	                    return cbBankDetails;
	                });
		
	}

}
