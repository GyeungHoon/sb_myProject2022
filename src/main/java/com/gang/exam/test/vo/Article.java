package com.gang.exam.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

	private String id;
	private String title;
	private String body;
	private String regDate;
	private String updateDate;
	private int userId;
	
	
}
