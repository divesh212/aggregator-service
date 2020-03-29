package com.nagarro.nagp.msa2.aggregatorservice.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDetails {
	UserDetails userDetails;
	List<Order> orders;
}
