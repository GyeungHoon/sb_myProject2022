<%@ include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="login">
  <form action="/member/doLogin">
  <div class="box-container">
    <h1 class="heading">로그인</h1>
    <label for="">아이디</label>
    <input type="text" name="email">
    <label for="">비밀번호</label>
    <input type="password" name="password">
    <button type="submit">로그인</button>
    <div class="join_IDPW">
      <a href="/member/join">회원가입</a>
      <a href="">아이디/비밀번호 찾기</a>
    </div>
  </div>
  </form>
</section>
<%@ include file="../common/footer.jsp"%>