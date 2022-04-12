<%@ include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="login">
  <form action="/member/doJoin">
    <div class="box-container">
      <h1 class="heading">회원가입</h1>
      <label for="">이름</label>
      <input type="text" name="name">
      <label for="">이메일</label>
      <input type="text" name="email">
      <label for="">비밀번호</label>
      <input type="password" name="password">
      <button type="submit">가입하기</button>
    </div>
  </form>
</section>
<%@ include file="../common/footer.jsp"%>