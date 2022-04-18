<%@ include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content-detail">
  <h1>게시물 수정</h1>
  <div>
  <form action="/article/doModify" method="POST">
  <input type="hidden" name="id" value="${article.id }" />
    <table>
      <tr>
        <th>번호</th>
        <td>${article.id}</td>
        <th>작성자</th>
        <td>${article.userId}</td>
      </tr>
      <tr>
        <th>작성날짜</th>
        <td>${article.regDate}</td>
        <th>수정날짜</th>
        <td>${article.updateDate}</td>
      </tr>
      <tr>
        <th>제목</th>
        <td colspan="3"><input type="text" name="title" value="${article.title}" maxlength="50" /></td>
      </tr>
      <tr class="detail-body">
        <th>내용</th>
        <td colspan="3"><textarea name="body" cols="20" rows="10" maxlength="500">${article.body}</textarea></td>
      </tr>
      
    </table>
    <div>
      <button type="submit" onclick="if ( confirm('정말 수정하시겠습니까?') == false ) return false;">수정</button>
      <button type="button" onclick="history.back();">뒤로가기</button>
    </div>
    </form>
  </div>
</section>
<%@ include file="../common/footer.jsp"%>