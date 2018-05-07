<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 03.05.18
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Homepage</a>
<a href="/user/logout">Logout</a>

<table>
    <tr>
        <td>tweetText</td>
        <td>created</td>
        <td>user</td>
    </tr>
    <%--@elvariable id="tweet" type="pl.coderslab.model.Tweet"--%>
    <c:forEach items="${usersTweetList}" var="tweet">
        <tr>
            <td>${tweet.text}</td>
            <td>${tweet.created}</td>
            <td>${tweet.user.username}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
