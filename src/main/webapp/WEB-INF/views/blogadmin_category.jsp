<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>블로그 관리페이지</title>
</head>
<body align=center>
<div>
    <h1>${blog.blogName}</h1>
    <h2>${blog.tag}</h2>
</div>
<a href="/">인덱스 페이지로 이동</a>
<div>
    <a href="/blogAdminView_basic.do?blogId=${blog.blogId}">기본 설정</a>
    <a href="/blogAdminView_category.do?blogId=${blog.blogId}">카테고리</a>
    <a href="/adminPostView.do?blogId=${blog.blogId}">글작성</a>
</div>

<div>
    <table border="1" width="700" align="center">
        <tr bgcolor="#e9967a">
            <th>번호</th>
            <th>카테고리명</th>
            <th>보이기 유형</th>
            <th>포스트 수</th>
            <th>설명</th>
            <th>삭제</th>
        </tr>
        <c:forEach var="category" varStatus="status" items="${categoryList }">
            <tr>
                <td>${status.count}</td>
                <c:if test="${category.categoryName == '미분류'}">
                    <td>미분류</td>
                </c:if>
                <c:if test="${category.categoryName != '미분류'}">
                    <td><a href = "">${category.categoryName}</a></td>
                </c:if>
                <td>${category.displayType}</td>
                <td>${category.cntDisplayPost}</td>
                <td>${category.description}</td>
                <c:if test="${category.categoryName == '미분류'}">
                    <td>삭제불가</td>
                </c:if>
                <c:if test="${category.categoryName != '미분류'}">
                    <td><a href="/blogAdmin_category_delete.do?blogId=${blog.blogId}&&categoryId=${category.categoryId}">삭제</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <form action="/blogAdmin_category_insert.do?blogId=${blog.blogId}" method="post">
        카테고리 등록
        <input name="blogId" type="hidden" value="${blog.blogId}"/>
        <table border="0.5" align="center">
            <tr>
                <td>카테고리명 :</td>
                <td><input type="text" name="categoryName"/></td>
            </tr>
            <tr>
                <td>보이기 유형 :</td>
                <td>
                    <label><input type="radio"
                                  name="displayType"
                                  value="제목"
                    >제목</label>
                    <label><input type="radio"
                                  name="displayType"
                                  value="제목+내용"
                    >제목+내용</label>
                </td>
            </tr>
            <tr>
                <td>포스트 수 :</td>
                <td><input type="text" name="cntDisplayPost"/></td>
            </tr>
            <tr>
                <td>설명 :</td>
                <td><input type="text" name="description"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="카테고리 추가">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>