<%-- 
    Document   : login
    Created on : 2016/12/05, 17:00:15
    Author     : g15927nm
--%>

<%@page language="java" contentType="text/html; charest=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ログイン</title>
    </head>
    <body bgcolor="oldlace">
    <form action="/ad1927/LoginServlet" method="post">
        ユーザーID:<input type="text" name="userId"><br>
        パスワード:<input type="password" name="pass"><br>
        <input type="submit" value="ログイン">
    </form>
    </body>
</html>
