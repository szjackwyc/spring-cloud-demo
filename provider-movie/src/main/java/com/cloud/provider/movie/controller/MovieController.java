package com.cloud.provider.movie.controller;

import java.util.List;

import com.cloud.provider.movie.vo.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.provider.movie.feign.AccountFeignClient;
import com.cloud.provider.movie.vo.Account;

@RestController
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private AccountFeignClient accountFeignClient;

	@RequestMapping("/list")
	public String getList() {
		// 提交代码测试
		return "hello list";
		// return restTemplate.getForObject("http://localhost:8090/user",
		// List.class);
	}

	@RequestMapping("/get")
	public UserAccount get(Integer id) {

		return accountFeignClient.findById(id);
	}

	@RequestMapping("/user-instance")
	public List<ServiceInstance> showInfo() {
		List<String> list = discoveryClient.getServices();
		for (String str : list) {
			System.out.println(str);
		}
		return discoveryClient.getInstances("provider-user");
	}

	@GetMapping("/log-user-instance")
	public ServiceInstance logUserInstance() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("provider-user");
		// 打印当前选择的是哪个节点
		MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(),
				serviceInstance.getPort());
		return serviceInstance;
	}

}
