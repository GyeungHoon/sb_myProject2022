<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 본문</h1>
<div>
    <div>
        <div>번호</div>
        <div>
            ${article.id}
        </div>
    </div>
    <hr>
    <div>
        <div>작성날짜</div>
        <div>
            ${article.regDate}
        </div>
    </div>
    <div>
        <div>수정날짜</div>
        <div>
            ${article.updateDate}
        </div>
    </div>
    <hr>
    <div>
        <div>제목</div>
        <div>
            ${article.title}
        </div>
    </div>
    <hr>
    <div>
        <div>내용</div>
        <div>
            ${article.body}
        </div>
    </div>
     <div>
        <div>내용</div>
        <div>
            ${article.userId}
        </div>
    </div>
    
</div>
</body>
</html>