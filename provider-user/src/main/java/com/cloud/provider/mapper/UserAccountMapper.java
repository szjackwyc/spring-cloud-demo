package com.cloud.provider.mapper;

import com.cloud.provider.entity.UserAccount;

public interface UserAccountMapper {
    int deleteByPrimaryKey(Long accountId);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(Long accountId);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);
}
