<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>블로그 생성</title>
</head>
<body align="center">
<h1>GBlog</h1>
<form action="/blogCreate.do" method="post">
    <input name="blogId" type="hidden" value="${user.userId}"/>
    <input name="userId" type="hidden" value="${user.userId}"/>
    <div>
        <input name="blogName" type="text" value="${user.userName }의 블로그"/>
        <input type="submit" value="블로그 생성"/>
    </div>
</form>
<a href="/">인덱스 페이지로 이동</a>
</body>
</html>
