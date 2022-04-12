<%@ include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="board">
  <div>
    <h1>공지사항</h1>
  </div>

  <div class="search-form">
    <input type="search" id="search-box" placeholder="검색어를 입력해 주세요.">
    <label for="search-box">검색</label>
  </div>


  <div class="content">
    <table>
      <thead>
        <tr>
          <th>NO</th>
          <th>작성날짜</th>
          <th>수정날짜</th>
          <th>제목</th>
          <th>작성자</th>

        </tr>
      </thead>
      <tbody>
        <c:forEach var="list" items="${list}">
          <tr>
            <td class="item">${list.id}</td>
            <td class="item">${list.regDate }</td>
            <td class="item">${list.updateDate }</td>
            
            <td class="item"><a href="detail?id=${list.id}">${list.title }</a></td>
       
            <td class="item">${list.userId }</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <div class="board-create">
    <a href="./boardwrite.html">
      <button type="button">글쓰기</button>
    </a>
  </div>
</section>

<%@ include file="../common/footer.jsp"%>