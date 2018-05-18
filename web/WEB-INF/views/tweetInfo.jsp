<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tweet by ${tweet.user.username}</title>
</head>
<body>
<a href="/">Homepage</a>
<a href="/user/logout">Logout</a>
<br>
<table>
    <tr>
        <td>tweetText</td>
        <td>created</td>
        <td>user</td>
    </tr>
    <%--@elvariable id="tweet" type="pl.coderslab.model.Tweet"--%>
    <tr>
        <td>${tweet.text}</td>
        <td>${tweet.created}</td>
        <td>${tweet.user.username}</td>
    </tr>
</table>
<br><br>
<table>

    <tr>
        <td>Comment:</td>
        <td>Author:</td>
        <td>Date:</td>
    </tr>
    <%--@elvariable id="comment" type="pl.coderslab.model.Comment"--%>
    <c:forEach items="${commentsList}" var="comment">
        <tr>
            <td>${comment.text}</td>
            <td>${comment.user.username}</td>
            <td>${comment.created}</td>
        </tr>
    </c:forEach>

</table>
<%--@elvariable id="comment" type="pl.coderslab.model.Comment"--%>
<form:form modelAttribute="comment">
    <form:errors path="*"/>

    <label for="text">Comment:</label>
    <form:textarea path="text" id="text"/>

    <button type="submit">Comment!</button>
</form:form>
</body>
</html>
