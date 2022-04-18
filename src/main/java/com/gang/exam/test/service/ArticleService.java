package com.gang.exam.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gang.exam.test.repository.ArticleRepository;
import com.gang.exam.test.vo.Article;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	public List<Article> getArticles(int itemsCountInAPage, int page, String searchKeyword, String searchKeywordTypeCode) {

		int limitStart = (page - 1) * itemsCountInAPage;
		int limitTake = itemsCountInAPage;

		List<Article> article = articleRepository.getArticles(limitStart, limitTake, searchKeyword, searchKeywordTypeCode);

		return article;
	}

	public Article detailArticle(int id) {

		return articleRepository.detailArticle(id);
	}

	public void writeArticle(int userId, String body, String title) {
		articleRepository.writeArticle(title, body, userId);

	}

	public void doDeleteArticle(int id) {
		articleRepository.doDeleteArticle(id);

	}

	public void doModifyArticle(int id, String title, String body) {
		articleRepository.doModifyArticle(id, title, body);

	}

	public int getArticlesCount(String searchKeyword, String searchKeywordTypeCode) {
		int articlesCount = articleRepository.getArticlesCount(searchKeyword,searchKeywordTypeCode);
		return articlesCount;
	}

}
