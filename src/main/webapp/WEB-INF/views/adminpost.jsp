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
            <div align="right"
                 style="font-size: 20px">
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
        <!-- 글 작성 -->
        <c:if test="${postUpdate == null}">
            <div align="left" style="width: 900px">
                <form action="/adminpost_insert.do?blogId=${blog.blogId}" method="post">
                    <div align="right" style="padding-right: 60px">
                        <select name="categoryId">
                            <c:forEach var="category" items="${categoryList}">
                                <option value="${category.categoryId}">${category.categoryName }</option>
                            </c:forEach>
                        </select>
                    </div>
                    <table border="0.5">
                        <tr>
                            <td>제목</td>
                            <td><input style="width: 800px; height: 40px;"
                                       type="text"
                                       name="title"
                                       value="제목을 입력하세요."/></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea style="width: 800px; height: 300px;"
                                          name="content">내용을 입력하세요.</textarea></td>
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
        <!-- 글 작성 종료-->
        <!-- 글 수정 -->
        <c:if test="${postUpdate != null}">
            <div align="left" style="width: 900px">
                <form action="/adminpost_update.do?blogId=${blog.blogId}&&postId=${postUpdate.postId}" method="post">
                    <div align="right" style="padding-right: 60px">
                        <select name="categoryId">
                            <c:forEach var="category" items="${categoryList}">
                                <option <c:if test="${postUpdate.categoryId == category.categoryId}">selected</c:if> value="${category.categoryId}">${category.categoryName }</option>
                            </c:forEach>
                        </select>
                    </div>
                    <table border="0.5">
                        <tr>
                            <td>제목</td>
                            <td><input style="width: 800px; height: 40px;"
                                       type="text"
                                       name="title"
                                       value="${postUpdate.title}"/></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea style="width: 800px; height: 300px;"
                                          name="content">${postUpdate.content}</textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="수정하기">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </c:if>
        <!-- 글 수정 종료 -->
    </div>
</div>
</body>
</html>