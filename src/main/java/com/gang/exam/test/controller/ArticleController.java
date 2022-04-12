package com.gang.exam.test.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gang.exam.test.service.ArticleService;
import com.gang.exam.test.vo.Article;
import com.gang.exam.test.vo.Member;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	@RequestMapping("list")
	public String list(Model model) {
		List<Article> list = articleService.serviceList();
		model.addAttribute("list",list);
		return "article/list";
	}

	@RequestMapping("listAdd")
	public String listAdd() {
		
		return "article/listWrite";
	}
	
	@RequestMapping("doListAdd")
	public String doListAdd(Model model, String title, String body, HttpSession httpSession) {
		
		boolean isLogined = false;
		int loginedMemberId = 0;
		
		if(httpSession.getAttribute("loginedMemberId") != null){
			isLogined = true;
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}

		
		if(isLogined == false) {
			model.addAttribute("msg", "로그인 후 이용해주세요");
			model.addAttribute("historyBack", "true");
			return "common/js";
		}
		if(loginedMemberId != 1) {
			
			model.addAttribute("msg", "작성권한이 없습니다");
			model.addAttribute("historyBack", "true");
			return "common/js";
	
		}
		
		
		 articleService.serviceListAdd(loginedMemberId, title, body ); 
		model.addAttribute("msg", "생성되었습니다");
		model.addAttribute("replaceUri", "/");
		return "common/js";
	}
	
	@RequestMapping("detail")
	public String showDetail(Model model, int id) {
		
		Article article = articleService.serviceDetail(id);
		model.addAttribute("article", article);
		
		return "article/detail";
	}
	
	
	@RequestMapping("listUpdate")
	@ResponseBody
	public String listUpdate(int id, String title, String body) {
		
		articleService.serviceListUpdate(id,title,body);
		return "수정이 완료되었습니다.";
	}
	
	
	@RequestMapping("listDelete")
	@ResponseBody
	public String listDelete(int id) {
		articleService.serviceListDelete(id);
		return "삭제되었습니다";
	}
	

}
