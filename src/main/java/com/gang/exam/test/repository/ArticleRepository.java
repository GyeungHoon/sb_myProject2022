package com.gang.exam.test.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gang.exam.test.vo.Article;

@Mapper
public interface ArticleRepository {

	@Select("<script>select id, title,regDate,updateDate,userId from article order by id desc</script>")
	public List<Article> repositoryList();

	@Select("<script>select id, title, body from article where id = ${id} </script>")
	public Article serviceDetail(int id);

	@Insert("<script>INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = #{title}, body = #{body}, userId = #{userId}   </script>")
	public void repositoryListAdd(String title, String body, int userId);

	@Delete("<script>DELETE FROM article where id = #{id}</script>")
	public void repositoryListDelete(int id);

	@Update("<script>UPDATE article SET updateDate = NOW(), title = #{title}, body= #{body} WHERE id = #{id}</script>")
	public void repositoryListUpdate(int id, String title, String body);

}
