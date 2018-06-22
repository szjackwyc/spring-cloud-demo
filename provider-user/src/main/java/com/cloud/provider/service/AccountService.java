package com.cloud.provider.service;

import java.util.List;

import com.cloud.provider.entity.Account;
import com.cloud.provider.entity.UserAccount;

public interface AccountService {
	
	// 查询所有账户
	List<Account> selectAll();


	UserAccount get(Integer accountId);
}
