package com.nagarro.nagp.msa2.aggregatorservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.nagp.msa2.aggregatorservice.entity.Order;
import com.nagarro.nagp.msa2.aggregatorservice.entity.UserDetails;
import com.nagarro.nagp.msa2.aggregatorservice.entity.UserOrderDetails;

@RestController
@RequestMapping("/orderdetails")
public class UserOrderDetailsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserOrderDetailsController.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${USER_SERVICE_URL:http://localhost:8091}")
	String userServiceUrl;

	@Value("${ORDER_SERVICE_URL:http://localhost:8092}")
	String orderServiceUrl;

	@GetMapping("/{id}")
	public UserOrderDetails getUserOrderDetails(@PathVariable("id") int id) {

		LOGGER.info("Request received for order details from user id: {}", id);
		UserOrderDetails userOrderDetails = new UserOrderDetails();

		LOGGER.info("Fetching user details from user service for id: {}", id);
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + "/user/" + String.valueOf(id),
				UserDetails.class);

		LOGGER.info("Fetching order details from order service for id: {}", id);
		List<Order> orderList = restTemplate.getForObject(orderServiceUrl + "/orders/" + String.valueOf(id),
				ArrayList.class);

		userOrderDetails.setUserDetails(userDetails);
		userOrderDetails.setOrders(orderList);

		return userOrderDetails;
	}
}
