<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>GBlog</title>
</head>
<body align="center">
<h1>GBlog</h1>
<c:if test="${user != null}">
    <h3>${user.userName }님 환영합니다</h3>
    <a href="/logout.do">로그아웃</a>
</c:if>
<div>
    <!-- 로그인 하지 않은 상태라면 로그인만 보인다. -->
    <c:if test="${user == null}">
        <a href="/loginView.do">로그인</a>
    </c:if>
    <!-- 블로그를 소유하지 않은 사용자가 로그인에 성공하면 블로그 등록만 보인다. -->
            <c:if test="${user != null && blog == null }">
    <a href="/blogCreateView.do">블로그 등록</a>
            </c:if>
    <!-- 블로그를 소유한 사용자가 로그인한 경우에 내 블로그로 가기만 보인다. -->
            <c:if test="${user != null && blog != null }">
    <a href="/blogMainView.do?blogId=${user.userId }">내 블로그로 가기</a>
            </c:if>
</div>

<!-- 검색 시작 -->
<form action="/?userId=${user.userId }" method="post">
    <div>
        <input name="searchKeyword" type="text" value="${search.searchKeyword}"/>
        <input type="submit" value="검색"/>
    </div>
    <div>
        <label><input type="radio"
                      name="searchCondition"
                      value="blogName"
                      <c:if test="${search.searchCondition == 'blogName'}">checked</c:if>>블로그 제목</label>
        <label><input type="radio"
                      name="searchCondition"
                      value="tag"
                      <c:if test="${search.searchCondition == 'tag'}">checked</c:if>>태그</label>
        <label><input type="radio"
                      name="searchCondition"
                      value="userName"
                      <c:if test="${search.searchCondition == 'userName'}">checked</c:if>>블로거</label>
    </div>
</form>
<!-- 검색 종료 -->
<c:if test="${search.searchKeyword != ''}">
<table border="1" width="700" align="center">
    <tr bgcolor="#e9967a">
        <th>블로그 제목</th>
        <th>블로거</th>
        <th>태그</th>
        <th>로고</th>
        <th>상태</th>
        <!-- ADMIN만 삭제 버튼을 볼 수 있다. -->
        <c:if test="${user.role == 'ADMIN'}">
            <th>삭제</th>
        </c:if>
    </tr>

    <!-- BlogList 시작 -->
    <c:forEach var="blog" items="${blogInfo }">
        <tr align="center">
            <td><a href="/blogMainView.do?blogId=${blog.BLOG_ID }">${blog.BLOG_NAME}</a></td>
            <td>${blog.USER_NAME}</td>
            <td>${blog.TAG}</td>
            <td>logo</td>
            <td>${blog.STATUS}</td>
            <c:if test="${user.role == 'ADMIN' && blog.STATUS == '삭제 요청'}">
                <td>
                    <a href="/deleteBlog.do?blogId=${blog.BLOG_ID}">삭제</a>
                </td>
            </c:if>
            <c:if test="${user.role == 'ADMIN' && blog.STATUS != '삭제 요청'}">
                <td>
                    <a>삭제 불가</a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    <!-- BlogList 종료 -->
    </c:if>

</table>
</body>
</html>
