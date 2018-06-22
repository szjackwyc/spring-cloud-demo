package com.cloud.provider.mapper;

import java.util.List;

	
import com.cloud.provider.entity.Account;


public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKeyWithBLOBs(Account record);

    int updateByPrimaryKey(Account record);
    
    List<Account> selectAll();
}