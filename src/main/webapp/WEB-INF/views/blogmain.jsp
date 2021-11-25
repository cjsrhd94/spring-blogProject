<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>블로그 메인</title>
</head>
<body align="center">
<h1>${blog.blogName}</h1>
<h2>${blog.tag}</h2>
<a href="/?userId=${user.userId }">인덱스 페이지로 이동</a>
<c:if test="${user.userId == blog.blogId}">
    <a href="/blogAdminView_basic.do?blogId=${blog.blogId}">블로그 관리</a>
</c:if>
<table border="1" width="700" align="center">
    <c:forEach var="board" items="${boardInfo }">
        <tr align="center">
            <td>${board.title}</td>
            <td>${board.content}</td>
            <td>${board.createdDate}</td>
            <c:if test="${user.userId == blog.blogId}">
                <td><a href="adminpostView_update.do?blogId=${blog.blogId}&&postId=${board.postId}">edit</a></td>
                <td><a href=/adminpost_delete.do?blogId=${blog.blogId}&&postId=${board.postId}>del</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<table border="1" width="300" align="center">

    <tr align="center">
        <td>카테고리</td>
        <td>
            <a href="/blogMainView.do?blogId=${blog.blogId}">전체보기</a>
        </td>
        <c:forEach var="category" items="${categoryList }">
            <td>
                <a href="/blogMainView.do?blogId=${blog.blogId}&&categoryId=${category.categoryId}">${category.categoryName}</a>
            </td>
        </c:forEach>
    </tr>
</table>
</body>
</html>