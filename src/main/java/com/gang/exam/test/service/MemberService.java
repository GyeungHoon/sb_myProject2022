package com.gang.exam.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gang.exam.test.repository.MemberRepository;
import com.gang.exam.test.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public int join(String email, String password, String name) {
		Member oldMember = getMemberByLoginId(email);
		if (oldMember != null) {
			return -1;
		}
		memberRepository.join(email, password, name);
		return memberRepository.getLastInsertId();
	}

	public Member getMemberByLoginId(String email) {

		return memberRepository.getMemberByLoginId(email);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}

}
