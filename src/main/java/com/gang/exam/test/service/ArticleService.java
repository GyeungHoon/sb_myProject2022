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

	public List<Article> serviceList(int itemsCountInAPage, int page) {
		
		int limitStart = (page - 1) * itemsCountInAPage;
		int limitTake = itemsCountInAPage;
		
		List<Article> article =  articleRepository.repositoryList(limitStart, limitTake);
				
		return article;
	}
	
	public Article serviceDetail(int id) {
		
		return articleRepository.serviceDetail(id);
	}

	public void serviceListAdd(int userId, String body, String title) {
		articleRepository.repositoryListAdd(title, body, userId);
		
		
	}
	public void serviceListDelete(int id) {
		articleRepository.repositoryListDelete(id);
		
	}

	public void serviceListUpdate(int id, String title, String body) {
		articleRepository.repositoryListUpdate(id, title, body);
		
	}


	
	
}
