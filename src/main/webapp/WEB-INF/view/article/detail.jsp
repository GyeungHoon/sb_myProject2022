<%@ include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content-detail">
  <h1>게시물 본문</h1>
  <div>
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
        <td colspan="3">${article.title}</td>
      </tr>
      <tr class="detail-body">
        <th>내용</th>
        <td colspan="3"><textarea cols="20" rows="10" readonly="readonly">${article.body}</textarea></td>
      </tr>
    </table>
    <div>
  <c:if test="${loginedMemberId == 1 }">
      <a href="/article/modify?id=${article.id}">수정</a>
      <a href="/article/doDelete?id=${article.id}"  onclick="if ( confirm('정말 삭제하시겠습니까?') == false ) return false;">삭제</a>
      </c:if>
    </div>
  </div>
</section>
<%@ include file="../common/footer.jsp"%>