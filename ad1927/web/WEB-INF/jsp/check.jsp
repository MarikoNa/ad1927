<%-- 
    Document   : check
    Created on : 2017/01/07, 19:45:16
    Author     : mariko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Login,model.Account,java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>確認画面</title>
    </head>
    <body bgcolor="oldlace">
        <h3><font color="darkorange">${account.getName()}</font>さんの今日の点数</h3>
        <style>
            table td {
                text-align: center;
            }
        </style>
        <table class="table" border=1>
            <tr><td>朝</td><td>${morning}　点</td></tr>
            <tr><td>昼</td><td>${noon}　点</td></tr> 
            <tr><td>夜</td><td>${night}　点</td></tr> 
            <tr><td>合計</td><td>${sum}　点</td></tr> 
        </table>
        1日<font color="orangered">20</font>点を目指しましょう！
        <a href="/ad1927/LoginServlet">戻る</a>
    </body>
</html>
