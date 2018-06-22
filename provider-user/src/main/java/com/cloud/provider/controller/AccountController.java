package com.cloud.provider.controller;

import java.util.List;

import com.cloud.provider.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.provider.entity.Account;
import com.cloud.provider.service.AccountService;


@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method=RequestMethod.GET,value = "/list.json")
	public List<Account> listAll(){
		return accountService.selectAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/get.json")
	public UserAccount getById(Integer accountId){
		return accountService.get(accountId);
	}

}
