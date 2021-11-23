<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>로그인</title>
</head>
<body align="center">
<h1>로그인 페이지</h1>
<div align="center">
    <form action="/login.do" method="post">
        <table border="1" align="center">
            <tr>
                <td bgcolor="#e9967a">아이디</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td bgcolor="#e9967a">비밀번호</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="로그인">
                </td>
            </tr>
        </table>
    </form>
</div>
<br>
<hr>
</body>
</html>