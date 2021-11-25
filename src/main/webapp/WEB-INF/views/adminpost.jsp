<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>블로그 관리페이지</title>
</head>
<body align=center>
<h1>${blog.blogName}</h1>
<h2>${blog.tag}</h2>
<a href="/">인덱스 페이지로 이동</a>
<div>
    <a href="/blogAdminView_basic.do?blogId=${blog.blogId}">기본 설정</a>
    <a href="/blogAdminView_category.do?blogId=${blog.blogId}">카테고리</a>
    <a href="/adminPostView.do?blogId=${blog.blogId}">글작성</a>
</div>
<c:if test="${postUpdate == null}">
<div>
    <form action="/adminpost_insert.do?blogId=${blog.blogId}" method="post">
        <select name= "categoryId">
            <c:forEach var="category" items="${categoryList}">
                <option value="${category.categoryId}">${category.categoryName }</option>
            </c:forEach>
        </select>
            <table border="0.5" align="center">
                <tr>
                    <td>제목 :</td>
                    <td><input type="text" name="title" value="제목을 입력하세요."/></td>
                </tr>
                <tr>
                    <td>내용 :</td>
                    <td><textarea name="content">내용을 입력하세요.</textarea></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="확인">
                    </td>
                </tr>
            </table>
    </form>
</div>
</c:if>
<c:if test="${postUpdate != null}">
    <div>
        <form action="/adminpost_update.do?blogId=${blog.blogId}&&postId=${postUpdate.postId}" method="post">
            <select name= "categoryId">
                <c:forEach var="category" items="${categoryList}">
                    <option value="${category.categoryId}">${category.categoryName }</option>
                </c:forEach>
            </select>
            <table border="0.5" align="center">
                <tr>
                    <td>제목 :</td>
                    <td><input type="text" name="title" value="${postUpdate.title}"/></td>
                </tr>
                <tr>
                    <td>내용 :</td>
                    <td><textarea name="content">${postUpdate.content}</textarea></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="확인">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</c:if>
</body>
</html>