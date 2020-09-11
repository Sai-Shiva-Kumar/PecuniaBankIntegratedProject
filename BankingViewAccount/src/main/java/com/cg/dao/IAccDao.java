package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Account;

public interface IAccDao  extends JpaRepository<Account, String>{

}
