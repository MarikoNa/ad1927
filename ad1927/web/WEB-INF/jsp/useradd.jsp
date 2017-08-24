<%-- 
    Document   : user
    Created on : 2017/01/07, 17:37:06
    Author     : mariko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザ登録</title>
    </head>
    <body bgcolor="oldlace">
        <h1><font color="seagreen">ユーザ登録</font></h1>
        <p>名前・ユーザーID・パスワードを登録してください。</p>
        <form action="/ad1927/UserAddServlet" method="post">
            名前:<input type="text" name="name"><br>
            ユーザーID:<input type="text" name="userId"><br>
            パスワード:<input type="password" name="pass"><br>
        <input type="submit" value="ユーザ登録">
        </form>
    </body>
</html>
