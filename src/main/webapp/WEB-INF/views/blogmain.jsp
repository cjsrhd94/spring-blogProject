<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>블로그 메인</title>
    <style>
        a {
            text-decoration: none;
            margin: 10px;
        }
    </style>
</head>
<body align="center">
<div align="center">
    <div style="width: 1000px" ;>
        <div style="background-color: lightblue; border-radius: 2em; height: 240px;">
            <div>
                <div style="font-size: 20px; padding-top: 30px">
                    <h1>${blog.blogName}</h1>
                </div>
                <div style="font-size: 20px;">
                    <h3>${blog.tag}</h3>
                </div>
            </div>
            <div align="right" style="font-size: 20px">
                <a href="/?userId=${user.userId }">블로그 검색</a>
                <a href="/blogMainView.do?blogId=${blog.blogId}">내 블로그 메인</a>
                <c:if test="${user == null}">
                    <a href="/loginView.do">로그인</a>
                </c:if>
                <c:if test="${user != null}">
                    <a href="/logout.do">로그아웃</a>
                </c:if>
            </div>
        </div>

        <c:if test="${user.userId == blog.blogId}">
            <div align="left" style="font-size: 20px; padding: 10px 0px 20px 0px;">
                <a href="/blogAdminView_basic.do?blogId=${blog.blogId}">블로그 관리</a>
            </div>
        </c:if>
        <hr>
        <div>
            <!-- 글 목록 출력 -->
            <table border="1" width="700" align="center">
                <c:forEach var="board" items="${boardInfo }">
                    <tr align="center">
                        <td>${board.TITLE}</td>
                        <td>
                            <c:if test="${board.DISPLAY_TYPE == '제목+내용'}">
                                ${board.CONTENT}
                            </c:if>
                        </td>
                        <td>${board.CREATED_DATE}</td>
                        <c:if test="${user.userId == blog.blogId}">
                            <td>
                                <a href="adminpostView_update.do?blogId=${blog.blogId}&&postId=${board.POST_ID}">edit</a>
                            </td>
                            <td><a href=/adminpost_delete.do?blogId=${blog.blogId}&&postId=${board.POST_ID}>del</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
            <!-- 글 목록 출력 종료 -->
            <!-- 카테고리 목록 출력 -->
            <table border="1" width="150" align="center">
                <th align="center" bgcolor="#add8e6">카테고리</th>
                <tr>
                    <td>
                        <a href="/blogMainView.do?blogId=${blog.blogId}">전체보기</a>
                    </td>
                </tr>
                <c:forEach var="category" items="${categoryList }">
                    <tr>
                        <td>
                            <a href="/blogMainView.do?blogId=${blog.blogId}&&categoryId=${category.categoryId}">${category.categoryName}</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <!-- 카테고리 목록 출력  종료-->
        </div>
    </div>
</div>
</body>
</html>