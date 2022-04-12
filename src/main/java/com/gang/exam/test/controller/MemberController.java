package com.gang.exam.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gang.exam.test.service.MemberService;
import com.gang.exam.test.vo.Member;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("join")
	public String showJoin() {
		
		return "user/join";
	}
	
	@RequestMapping("doJoin")
	public Object doJoin(Model model, String email, String password, String name) {
	
		int id = memberService.join(email, password, name);
		
		if(name.trim().isEmpty() || name.trim().equals("")) {
			model.addAttribute("msg", "이름을 입력해주세요");
			model.addAttribute("historyBack", "true");
			return "common/js";
		}
		
		if(email.trim().isEmpty() || email.trim().equals("") ) {
			model.addAttribute("msg", "email를 입력해주세요");
			model.addAttribute("historyBack", "true");
			return "common/js";
		}
		if(password.trim().isEmpty() || password.trim().equals("")) {
			model.addAttribute("msg", "password를 입력해주세요");
			model.addAttribute("historyBack", "true");
			return "common/js";
		}
		
		if(id == -1 ) {
			model.addAttribute("msg", "해당 아이디는 사용중입니다.");
			model.addAttribute("historyBack", "true");
			return "common/js";
		}
		
	
		
		//Member member = memberService.getMemberById(id);
		model.addAttribute("msg", "회원가입을 축하드립니다.");
		model.addAttribute("replaceUri", "login");
		return "common/js";
	}
	

	@RequestMapping("login")
	public String showLogin() {
		
		return "user/login";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(Model model,HttpSession httpSession, HttpServletRequest req, HttpServletResponse resp, String email, String password) {

		
		if(email.trim().isEmpty() || email.trim().equals("")) {
			
			model.addAttribute("msg", "email을 입력해주세요");
			model.addAttribute("historyBack", "true");
			return "common/js";
		}
		
		if(password.trim().isEmpty() || password.trim().equals("")) {
			model.addAttribute("msg", "password을 입력해주세요");
			model.addAttribute("historyBack", "true");
			return "common/js";
		}
		
		
		Member member= memberService.getMemberByLoginId(email);
		if(member == null) {
			model.addAttribute("msg", "존재하지 않은 email입니다.");
			model.addAttribute("historyBack", "true");
			return "common/js";
		}
		
		if(member.getPassword().equals(password) == false) {
			model.addAttribute("msg", "password가 일치하지 않습니다.");
			model.addAttribute("historyBack", "true");
			return "common/js";
		}
		
		httpSession.setAttribute("loginedMemberId", member.getId());
		
		
		return "main";
	}
	
	@RequestMapping("doLogout")
	public String doLogout(Model model, HttpSession httpSession) {
		
		httpSession.invalidate();

		return "redirect:/";
		
	}

}
