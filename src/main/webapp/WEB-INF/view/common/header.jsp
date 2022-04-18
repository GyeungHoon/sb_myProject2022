<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&display=swap" rel="stylesheet">

<!-- 사이트 공통 CSS -->
<link rel="stylesheet" href="/resource/assets/CSS/style.css" />
<!-- 사이트 공통 JS -->
<script type="text/javascript" src="/resource/assets/JS/script.js" defer="defer"></script>

</head>
<body>
  <!-- header 영역 -->
  <header class="header">
    <a class="logo" href="/">
      <img src="/resource/assets/images/logo.png" alt="">
    </a>
    <nav class="navbar">
      <a href="/">홈</a>
      <a href="/article/image">사진</a>
      <a href="/article/list">공지사항</a>
      <!--  <a href="/article/list">게시판</a> -->
      <!-- <a href="/article/write">작성</a> -->

    </nav>
    <div class="icons">
      <c:if test="${loginedMemberId == null}">
        <a href="/member/login"> 로그인 </a>
        <a href="/member/join"> 회원가입 </a>
      </c:if>
      <c:if test="${loginedMemberId != null}">
        <a href="/member/doLogout"> 로그아웃 </a>
       <!--  <a href="./myPage"> 마이페이지 </a> -->
      </c:if>
      <div class="fas fa-bars" id="menu-btn"></div>
    </div>
  </header>
  <!-- header 영역 끝 -->