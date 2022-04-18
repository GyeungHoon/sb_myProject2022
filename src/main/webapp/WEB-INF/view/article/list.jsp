<%@ include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="board">
  <div>
    <h1>공지사항</h1>
  </div>
<form >
  <div class="search-form">
    <input name="searchKeyword" type="search" id="search-box" placeholder="검색어를 입력해 주세요." value="${param.searchKeyword}">
    <button type="submit">검색</button>
  </div>
</form>
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

            <td class="item">
              <a href="detail?id=${list.id}">${list.title }</a>
            </td>

            <td class="item">${list.extra__name }</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>


  <div>
    <div class="board-paging-btn">
      <c:set var="pageMenuArmLen" value="4" />
      <c:set var="startPage" value="${page - pageMenuArmLen >= 1 ? page - pageMenuArmLen : 1}" />
      <c:set var="endPage" value="${page + pageMenuArmLen <= pagesCount ? page + pageMenuArmLen : pagesCount}" />
      <c:set var="pageBaseUri" value="?searchKeyword=${param.searchKeyword}"/>


      <c:if test="${startPage > 1}">
        <a href="${pageBaseUri }&page=1">1</a>
        <c:if test="${startPage > 2}">
          <a>...</a>
        </c:if>
      </c:if>
      <c:forEach begin="${startPage}" end="${endPage}" var="i">
        <a ${page == i ? 'btn-active' : ''}" href="${ pageBaseUri}&page=${i}">${i}</a>
      </c:forEach>
      <c:if test="${endPage < pagesCount}">
        <c:if test="${endPage < pagesCount - 1}">
          <a>...</a>
        </c:if>
        <a href="${pageBaseUri }&page=${pagesCount}">${pagesCount}</a>
      </c:if>
    </div>
  </div>

  <div class="board-create">
    <a href="/article/write">
      <c:if test="${loginedMemberId == 1}">
        <button type="button">글쓰기</button>
      </c:if>
    </a>
  </div>
</section>

<%@ include file="../common/footer.jsp"%>