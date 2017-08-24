<%-- 
    Document   : loginOK
    Created on : 2016/12/05, 16:59:53
    Author     : g15927nm
--%>

<%@page language="java" contentType="text/html; charest=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>ログイン完了</title>
    </head>
    <body bgcolor="oldlace">
        <p>ようこそ<font color="darkorange"><c:out value="${account.getName()}" /></font>さん</p>
        <ul>
            <li><a href="/ad1927/Main">食品選択画面へ</a></li>
            <li><a href="/ad1927/CheckServlet">点数確認画面へ</a></li>
            <li><a href="/ad1927/Logout">ログアウト</a></li>
        </ul>
    </body>
</html>
