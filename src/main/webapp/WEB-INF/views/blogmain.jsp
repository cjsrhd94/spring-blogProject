<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>블로그 메인</title>
</head>
<body align="center">
<h1>${blog.blogName}</h1>
<h2>${blog.tag}</h2>
<a href="/">인덱스 페이지로 이동</a>
<c:if test="${user.userId == blog.blogId}">
    <a href="/blogAdminView_basic.do?blogId=${blog.blogId}">블로그 관리</a>
</c:if>
<table border="1" width="700" align="center">
    <c:forEach var="board" items="${boardList }">
        <tr align="center">
            <td><a href="/blogMainView.do?blogId=${blog.blogId }">${board.blogName}</a></td>
            <td>블로거</td>
            <td>${board.tag}</td>
            <td>logo</td>
            <td>${board.status}</td>
            <c:if test="${user.role == 'ADMIN'}">
                <td>edit</td>
                <td>del</td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>