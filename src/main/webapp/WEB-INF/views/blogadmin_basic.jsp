<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>블로그 관리페이지</title>
</head>
<body align=center>
<div>
    <h1>${blog.blogName}</h1>
    <h2>${blog.tag}</h2>
    <a href="/?userId=${user.userId }">인덱스 페이지로 이동</a>
</div>
<div>
    <a href="/blogAdminView_basic.do?blogId=${blog.blogId}">기본 설정</a>
    <a href="/blogAdminView_category.do?blogId=${blog.blogId}">카테고리</a>
    <a href="/adminPostView.do?blogId=${blog.blogId}">글작성</a>
    <a href="/requestDeleteBlog.do?blogId=${blog.blogId}&&userId=${user.userId}">삭제요청</a>
</div>
<div>
    <form action="/blogAdmin_basic_update.do?blogId=${blog.blogId}" method="post">
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
                <td><input type="text" name="cntDisplayPost" value="${blog.cntDisplayPost}"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="확인">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>