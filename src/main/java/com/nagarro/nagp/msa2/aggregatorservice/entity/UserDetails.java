package com.nagarro.nagp.msa2.aggregatorservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
	private String name;
	private String age;
	private String email;
}
