<%@ include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="doListAdd" method="POST">
<div class="film-write">
  <div class="film-write-title">
    <input type="text" name="title" id="" maxlength='20' placeholder="제목을 입력해주세요. 20자 이하">
  </div>

  <div class="film-write-content">
    <textarea name="body" id="" maxlength='300' placeholder="내용을 입력해주세요 300자 이하"></textarea>
  </div>

  <div class="film-write-form">
    <button type="submit">등록하기</button>
  </div>
</div>

</form>
<%@ include file="../common/footer.jsp"%>