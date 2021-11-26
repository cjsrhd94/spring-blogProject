<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>블로그 관리페이지</title>
    <style>
        a {
            text-decoration: none;
            margin: 10px;
        }
    </style>
</head>
<body align=center>
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
        <div align="left" style="font-size: 20px; padding: 10px 0px 20px 0px;">
            <a href="/blogAdminView_basic.do?blogId=${blog.blogId}">기본 설정</a>
            <a href="/blogAdminView_category.do?blogId=${blog.blogId}">카테고리</a>
            <a href="/adminPostView.do?blogId=${blog.blogId}">글작성</a>
            <a href="/requestDeleteBlog.do?blogId=${blog.blogId}&&userId=${user.userId}">삭제요청</a>
        </div>
        <hr>
        <!-- 블로그 기본 설정 -->
        <div>
            <form action="/blogAdmin_basic_update.do?blogId=${blog.blogId}" method="post">
                <div style="padding: 10px 0px 20px 0px;">
                    <h3>기본 설정</h3>
                </div>
                <table border="0.5" align="center">
                    <tr>
                        <td>블로그 제목 :</td>
                        <td><input type="text" name="blogName" value="${blog.blogName}"/></td>
                    </tr>
                    <tr>
                        <td>블로그 태그 :</td>
                        <td><input type="text" name="tag" value="${blog.tag}"/></td>
                    </tr>
                    <tr>
                        <td>메인페이지 포스트 :</td>
                        <td><input type="number" name="cntDisplayPost" value="${blog.cntDisplayPost}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="확인">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <!-- 블로그 기본 설정 종료-->
    </div>
</div>
</body>
</html>