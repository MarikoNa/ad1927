<%-- 
    Document   : main
    Created on : 2017/01/13, 12:22:48
    Author     : kubotamari
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    // セッションスコープに保存されたつぶやきリストを取得
    //ArrayList<String> foodList = (ArrayList<String>) request.getAttribute("foodList");
    // リクエストスコープに保存されたエラーメッセージを取得
    //String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>食品入力</title>
    </head>
    <body bgcolor="oldlace">
        <h1><font color="seagreen">今日食べた食品は?</font></h1>
        食べたものを選択して、「追加」ボタンを押してください。<br>
        すべて追加し終えたら、朝・昼・夕食を選択して、
        「完了」ボタンを押してください。<br>
        <br>
        <form action="/ad1927/Main" method ="post">
        <ul>
            <li>乳製品
                <select name="dailyproduct">
                    <option value="">選択</option>
                    <option value="牛乳">牛乳</option>
                    <option value="クリーム">クリーム</option>
                    <option value="チーズ">チーズ</option>
                    <option value="ヨーグルト">ヨーグルト</option>                   
                    <option value="その他（乳製品）">その他（乳製品）</option>
                </select>    
            </li>
            <li>卵
                <select name="egg">
                    <option value="">選択</option>
                    <option value="鶏卵">鶏卵</option>
                    <option value="うずらの卵">うずらの卵</option>
                </select>
            </li>
            <li>野菜
                <select name="vegetable">
                    <option value="">選択</option>
                    <option value="レタス">レタス</option>
                    <option value="きゅうり">きゅうり</option>
                    <option value="大根">大根</option>
                    <option value="トマト">トマト</option>
                    <option value="ほうれん草">ほうれん草</option>
                    <option value="キャベツ">キャベツ</option>
                    <option value="春菊">春菊</option>
                    <option value="なす">なす</option>
                    <option value="にんじん">にんじん</option>
                    <option value="玉ねぎ">玉ねぎ</option>
                    <option value="かぼちゃ">かぼちゃ</option>
                </select>
            </li>
            <li>きのこ
                <select name="mushroom">
                    <option value="">選択</option>
                    <option value="えのき">えのき</option>
                    <option value="エリンギ">エリンギ</option>
                    <option value="しいたけ（生）">しいたけ（生）</option>
                </select>
            </li>
            <li>海藻
                <select name="seaweed">
                    <option value="">選択</option>
                    <option value="湯通しわかめ">わかめ</option>
                    <option value="ひじき">ひじき</option>;
                </select>
            </li>
            <li>芋
                <select name="potatos">
                    <option value="">選択</option>
                    <option value="じゃがいも">じゃがいも</option>
                    <option value="さつまいも">さつまいも</option>
                    <option value="里芋">里芋</option>
                </select>
            </li>
            <li>果物
                <select name="fruits">
                    <option value="">選択</option>
                    <option value="バナナ">バナナ</option>
                    <option value="りんご">りんご</option>
                    <option value="みかん">みかん</option>
                    <option value="グレープフルーツ">グレープフルーツ</option>
                    <option value="いちご">いちご</option>
                    <option value="メロン">メロン</option>
                    <option value="その他（果物）">その他（果物）</option>
                </select>
            </li>
            <li>肉
                <select name="flesh">
                    <option value="">選択</option>
                    <option value="牛肉">牛肉</option>
                    <option value="豚肉">豚肉</option>
                    <option value="鶏肉">鶏肉</option>
                    <option value="ウインナー">ウインナー</option>
                    <option value="その他(肉)">その他(肉)</option>
                </select>
            </li>
            <li>魚介類
                <select name="fish">
                    <option value="">選択</option>
                    <option value="アジ">アジ</option>
                    <option value="イワシ">イワシ</option>
                    <option value="カツオ">カツオ</option>
                    <option value="サンマ">サンマ</option>
                    <option value="サケ">サケ</option>
                    <option value="シシャモ">シシャモ</option>
                    <option value="サバ">サバ</option>
                    <option value="マグロ">マグロ</option>
                    <option value="イカ">イカ</option>
                    <option value="タコ">タコ</option>
                    <option value="エビ">エビ</option>
                    <option value="カニ">カニ</option>
                    <option value="アサリ">アサリ</option>
                    <option value="シジミ">シジミ</option>
                    <option value="ウニ">ウニ</option>
                    <option value="その他(魚介類)">その他(魚介類)</option>    
                </select>
            </li>
            <li>穀物
                <select name="grain">
                    <option value="">選択</option>
                    <option value="白米">白米</option>
                    <option value="うどん">うどん</option>
                    <option value="そば">そば</option>
                    <option value="中華麺">中華麺</option>
                    <option value="スパゲッティ">スパゲッティ</option>
                    <option value="食パン">食パン</option>
                    <option value="トウモロコシ">トウモロコシ</option>
                    <option value="その他(穀物)">その他(穀物)</option>
                </select>
            </li>
            <li>油・糖
                <select name="oands">
                    <option value="">選択</option>
                    <option value="砂糖">砂糖</option>
                    <option value="マヨネーズ">マヨネーズ</option>
                    <option value="油系(バター、マーガリン)">油系(バター、マーガリン)</option>
                    <option value="飲み物(ジュース、お酒)">飲み物(ジュース、お酒)</option>
                    <option value="アイスクリーム">アイスクリーム</option>
                    <option value="チョコ">チョコ</option>
                    <option value="プリン">プリン</option>
                    <option value="ポテトチップス">ポテトチップス</option>
                    <option value="ビスケット">ビスケット</option>
                    <option value="せんべい">せんべい</option>
                    <option value="その他(その他)">その他(油・糖)</option>  
                </select>
            </li>
        </ul>
        <input type="submit" value="追加"><br>
        </form>
        
        <c:if test="${not empty foodList}">
        <c:forEach var = "String" items="foodList">
            <p><c:out value="${foodList}" /></p>
        </c:forEach>
            <form action="/ad1927/ResultServlet" method ="post">
            <br>
            <input type="radio" name="meal" value="MORNING" />朝食　
            <input type="radio" name="meal" value="NOON" />昼食　
            <input type="radio" name="meal" value="NIGHT" />夕食　
            <br>
            <br>
            <input type="submit" value="完了">
            </form>
        </c:if>
            <a href="/ad1927/LoginServlet">メニューへ</a>
    </body>
</html>
