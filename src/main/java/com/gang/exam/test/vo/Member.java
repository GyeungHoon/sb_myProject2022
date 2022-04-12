package com.gang.exam.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	private int id;
	private String reg_date;
	private String update_date;
	private String email;
	private String password;
	private String name;
	
}
