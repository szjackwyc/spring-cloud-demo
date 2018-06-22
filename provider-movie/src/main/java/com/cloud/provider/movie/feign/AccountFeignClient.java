package com.cloud.provider.movie.feign;

import com.cloud.provider.movie.vo.UserAccount;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.provider.movie.config.FeignLogConfiguration;
import com.cloud.provider.movie.vo.Account;

@FeignClient(name = "provider-user",configuration = FeignLogConfiguration.class, fallback = AccountFeignClientFallback.class)
public interface AccountFeignClient {

	@RequestMapping(value = "/user/get.json", method = RequestMethod.GET)
	public UserAccount findById(@RequestParam("accountId") Integer id);
}
@Component
class AccountFeignClientFallback implements AccountFeignClient {

	@Override
	public UserAccount findById(Integer id) {
		UserAccount account = new UserAccount();
		account.setAccountId(-1l);
	    account.setUsername("默认用户");
	    return account;
	}
}
