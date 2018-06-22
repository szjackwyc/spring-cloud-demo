package com.cloud.provider.service.impl;

import java.util.List;

import com.cloud.provider.entity.Account;
import com.cloud.provider.entity.UserAccount;
import com.cloud.provider.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.provider.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private UserAccountMapper userAccountMapper;

	@Override
	public List<Account> selectAll() {
		return null;
	}

	@Override
	public UserAccount get(Integer accountId) {
		return userAccountMapper.selectByPrimaryKey(Long.valueOf(accountId));
	}
	
	
}
