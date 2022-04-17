package com.gang.exam.test.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gang.exam.test.vo.Article;

@Mapper
public interface ArticleRepository {

	@Select("<script>SELECT id, title,regDate, updateDate, userId FROM article ORDER BY id DESC LIMIT #{limitStart}, #{limitTake} </script>")
	public List<Article> getArticles(@Param("limitStart")int limitStart, @Param("limitTake")int limitTake);

	@Select("<script>select id, title, body,regDate, updateDate, userId from article where id = ${id} </script>")
	public Article detailArticle(int id);

	@Insert("<script>INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = #{title}, body = #{body}, userId = #{userId}   </script>")
	public void writeArticle(String title, String body, int userId);

	@Delete("<script>DELETE FROM article where id = #{id}</script>")
	public void doDeleteArticle(int id);

	@Update("<script>UPDATE article SET updateDate = NOW(), title = #{title}, body= #{body} WHERE id = #{id}</script>")
	public void doModifyArticle(int id, String title, String body);

	@Select("<script> SELECT COUNT(*) FROM article </script>")
	public int getArticlesCount();

}
