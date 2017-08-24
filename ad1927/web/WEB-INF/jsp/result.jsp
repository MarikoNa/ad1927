<%-- 
    Document   : result
    Created on : 2017/01/13, 21:21:13
    Author     : kubotamari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>結果</title>
    </head>
    <body bgcolor="oldlace">
        <h1><font color="seagreen">結果</font></h1>
        今日の<c:out value="${account.getName()}" />さんの<c:out value="${showTime}" />は
        <h2><font color="orangered"><c:out value="${point}" /></h2></font>点です。<br>
        
        <h2>群ごとの点数</h2><br>
        １群：　<c:out value="${nPoint[0]}" />点<br>
        ２群：　<c:out value="${nPoint[1]}" />点<br>
        ３群：　<c:out value="${nPoint[2]}" />点<br>
        ４群：　<c:out value="${nPoint[3]}" />点<br>
        
        <br>
        <h2>選択された各食品の1点分の重量</h2><br>
        <style>
            table td {
                text-align: center;
            }
        </style>
        <table class="table" border=1>
        <c:forEach var="food" items="${foodsList}">
            <tr>
                <td><c:out value="${food.getNumber()}"/>群</td>
                <td><c:out value="${food.getName()}"/></td>
                <td><c:out value="${food.getWeight()}"/>g</td>
            </tr>
        </c:forEach>
        </table> 
        <br>
        <a href="/ad1927/Logout">ログアウト</a><br>
        <a href="/ad1927/CheckServlet">確認画面へ</a><br>
        <a href="/ad1927/LoginServlet">メニューへ戻る</a><br>
    </body>
</html>
