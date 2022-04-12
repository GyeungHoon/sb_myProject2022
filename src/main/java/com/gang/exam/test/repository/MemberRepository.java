package com.gang.exam.test.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gang.exam.test.vo.Member;

@Mapper
public interface MemberRepository {

	
	@Insert("INSERT INTO user SET regDate = NOW(), updateDate = NOW(), email=#{email}, password=#{password}, name = #{name}")
	public void join(String email, String password, String name);

	@Select("select * from user as  A where A.email = #{email} ")
	public Member getMemberByLoginId(String email);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

	
	@Select("SELECT * FROM `user` AS U WHERE U.id = #{id} ")
	public Member getMemberById(int id);
	
	
}
