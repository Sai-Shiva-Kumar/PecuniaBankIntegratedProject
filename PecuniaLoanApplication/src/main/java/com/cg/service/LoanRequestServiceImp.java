package com.cg.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.CustomerDao;
import com.cg.dao.LoanRequestDao;
import com.cg.dto.LoanRequestDto;
import com.cg.entity.Customer;
import com.cg.entity.LoanRequest;
import com.cg.util.CgConstants;
@Service
public class LoanRequestServiceImp implements LoanRequestService {
	@Autowired
	LoanRequestDao lrdao;
	
	@Autowired
	CustomerDao custdao;
	
		@Override
	@Transactional(readOnly=false)
	public String createLoanRequest(LoanRequestDto loanreqdto) {
		LoanRequest loanrequest=new LoanRequest();
		LocalDateTime now = LocalDateTime.now();
		LocalDate now1=LocalDate.now();

		String loanID = CgConstants.LOAN+loanreqdto.getCustomerId()+now.getSecond();
		loanrequest.setLoanRequestId(loanID);
		loanrequest.setLoanAmount(loanreqdto.getLoanAmount());
		loanrequest.setLoanType(loanreqdto.getLoanType());
		loanrequest.setLoanTenure(loanreqdto.getLoanTenure());
		loanrequest.setReqStatus(CgConstants.PENDING);
		loanrequest.setDateOfRequest(LocalDate.now());
		loanrequest.setAnnualIncome(loanreqdto.getAnnualIncome());
		Customer cust=custdao.getCustomer(loanreqdto.getCustomerId());
		loanrequest.setCustomer(cust);
	    LoanRequest persistedLr=lrdao.save(loanrequest);
		return loanID;
	}

}
