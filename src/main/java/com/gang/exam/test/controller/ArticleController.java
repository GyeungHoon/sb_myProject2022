package com.gang.exam.test.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gang.exam.test.service.ArticleService;
import com.gang.exam.test.vo.Article;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping("list")
	public String showList(Model model, @RequestParam(defaultValue = "1") int page, 
			@RequestParam(defaultValue = "title,body")String searchKeywordTypeCode, @RequestParam(defaultValue = "")String searchKeyword) {

		int articlesCount = articleService.getArticlesCount(searchKeyword, searchKeywordTypeCode);
		int itemsCountInAPage = 10;
		int pagesCount = (int) Math.ceil((double) articlesCount / itemsCountInAPage);
		List<Article> list = articleService.getArticles(itemsCountInAPage, page, searchKeyword, searchKeywordTypeCode);

		model.addAttribute("page", page);
		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("list", list);
		return "article/list";
	}

	@RequestMapping("write")
	public String write() {

		return "article/write";
	}

	@RequestMapping("doWrite")
	public String doWrite(Model model, String title, String body, HttpSession httpSession) {

		boolean isLogined = false;
		int loginedMemberId = 0;

		if (httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}

		if (isLogined == false) {
			model.addAttribute("msg", "로그인 후 이용해주세요");
			model.addAttribute("historyBack", "true");
			return "common/js";
		}

		articleService.writeArticle(loginedMemberId, title, body);
		model.addAttribute("msg", "생성되었습니다");
		model.addAttribute("replaceUri", "/");
		return "common/js";
	}

	@RequestMapping("detail")
	public String showDetail(Model model, int id) {

		Article article = articleService.detailArticle(id);
		model.addAttribute("article", article);

		return "article/detail";
	}
	
	@RequestMapping("modify")
	public String modify(Model model, int id) {
		
		Article article = articleService.detailArticle(id);
		model.addAttribute("article", article);
		return "article/modify";
	}

	@RequestMapping("doModify")
	public String doModify(Model model,RedirectAttributes redirect, int id, String title, String body) {
		redirect.addAttribute("id", id);
		articleService.doModifyArticle(id, title, body);
	 return "redirect:detail";
	}

	@RequestMapping("doDelete")
	public String doDelete(RedirectAttributes redirect, int id) {
		articleService.doDeleteArticle(id);
		
		return "redirect:list";
	}
}
